package com.abed.HexagonRecyclerView.view.misc;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.abed.HexagonRecyclerView.R;
import com.abed.HexagonRecyclerView.controller.HorizontalOverlapDecorator;

/**
 * Created by mindvalley on 02/06/2016.
 */

public class HexagonRecyclerView extends RecyclerView {
    public HexagonRecyclerView(Context context) {
        super(context);
        configure(null);
    }

    public HexagonRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        configure(attrs);
    }

    public HexagonRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        configure(attrs);
    }

    private void configure(@Nullable AttributeSet attrs) {

        //Deflate the custom XML attributes
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.HexagonRecyclerView,
                0, 0);

        int row_size = 2;
        float horizontal_spacing = 0;
        float vertical_spacing = 0;
        int orientation = 0;
        try {
            horizontal_spacing = typedArray.getDimension(R.styleable.HexagonRecyclerView_items_horizontal_spacing, 0.0f);
            vertical_spacing = typedArray.getDimension(R.styleable.HexagonRecyclerView_items_vertical_spacing, 0.0f);
            row_size = typedArray.getInt(R.styleable.HexagonRecyclerView_items_count_in_row, 2);
            orientation = typedArray.getInt(R.styleable.HexagonRecyclerView_orientation, 0);
        } finally {
            typedArray.recycle();
        }

        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), row_size);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 3) {
                    case 0:
                        return 2;
                    default:
                        return 1;
                }
            }
        });

        setLayoutManager(mLayoutManager);
        addItemDecoration(new HorizontalOverlapDecorator(row_size, horizontal_spacing, vertical_spacing));
    }
}
