package com.abed.hexagonrecyclerview.view;

import android.content.Context;
import android.util.AttributeSet;

import com.abed.hexagonrecyclerview.R;
import com.github.siyamed.shapeimageview.shader.ShaderHelper;
import com.github.siyamed.shapeimageview.shader.SvgShader;

/**
 * Created by Mindvalley on 3/14/16.
 */
public class HorizontallyAdaptableHexagonImageView extends HexagonImageView {


    public HorizontallyAdaptableHexagonImageView(Context context) {
        super(context);
    }

    public HorizontallyAdaptableHexagonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontallyAdaptableHexagonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        double width = 1.1547005383 * height; //(sqrt(3)/2)
        setMeasuredDimension((int) width, height);
    }

    @Override
    public ShaderHelper createImageViewHelper() {
        return new SvgShader(R.raw.horizontal_hexagon);
    }

}
