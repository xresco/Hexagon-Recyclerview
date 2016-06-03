package com.abed.hexagonrecyclerview.view;

import android.content.Context;
import android.util.AttributeSet;

import com.abed.hexagonrecyclerview.R;
import com.github.siyamed.shapeimageview.shader.ShaderHelper;
import com.github.siyamed.shapeimageview.shader.SvgShader;


/**
 * Created by Mindvalley on 3/14/16.
 */
public class VerticallyAdaptableHexagonImageView extends HexagonImageView {

    public VerticallyAdaptableHexagonImageView(Context context) {
        super(context);
    }

    public VerticallyAdaptableHexagonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticallyAdaptableHexagonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        double height = 1.1547005383 * width; //(sqrt(3)/2)
        setMeasuredDimension(width, (int) height);
    }


    @Override
    public ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.vertical_hexagon);
    }

}
