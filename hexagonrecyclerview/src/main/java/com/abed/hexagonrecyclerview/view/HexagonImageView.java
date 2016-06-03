package com.abed.hexagonrecyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.github.siyamed.shapeimageview.ShaderImageView;

/**
 * Created by mindvalley on 03/06/2016.
 */


public abstract class HexagonImageView extends ShaderImageView {


    /**
     * Max allowed duration for a "click", in milliseconds.
     */
    private static final int MAX_CLICK_DURATION = 1000;
    /**
     * Max allowed distance to move during a "click", in DP.
     */
    private static final int MAX_CLICK_DISTANCE = 15;
    private long pressStartTime;
    private float pressedX;
    private float pressedY;
    private boolean stayedWithinClickDistance;


    public HexagonImageView(Context context) {
        super(context);
    }

    public HexagonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HexagonImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                pressStartTime = System.currentTimeMillis();
                pressedX = event.getX();
                pressedY = event.getY();
                stayedWithinClickDistance = true;
                return checkIfClickInsideTheCircle(event.getX(), event.getY());
            }
            case MotionEvent.ACTION_MOVE: {
                if (stayedWithinClickDistance && distance(pressedX, pressedY, event.getX(), event.getY()) > MAX_CLICK_DISTANCE) {
                    stayedWithinClickDistance = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                long pressDuration = System.currentTimeMillis() - pressStartTime;
                if (pressDuration < MAX_CLICK_DURATION && stayedWithinClickDistance) {
                    // Click event has occurred
                    boolean inside = checkIfClickInsideTheCircle(event.getX(), event.getY());
                    if (inside)
                        performClick();
                    return inside;
                }
            }
        }
        return false;

    }


    private boolean checkIfClickInsideTheCircle(float touchX, float touchY) {
        float centerX, centerY, radius;
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        radius = centerX - 20;
        if (Math.pow(touchX - centerX, 2)
                + Math.pow(touchY - centerY, 2) < Math.pow(radius, 2)) {
            return true;
        } else {
            return false;
        }
    }


    private float distance(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        float distanceInPx = (float) Math.sqrt(dx * dx + dy * dy);
        return pxToDp(distanceInPx);
    }

    private float pxToDp(float px) {
        return px / getResources().getDisplayMetrics().density;
    }
}
