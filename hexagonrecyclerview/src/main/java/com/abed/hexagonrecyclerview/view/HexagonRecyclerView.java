package com.abed.hexagonrecyclerview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.abed.hexagonrecyclerview.R;
import com.abed.hexagonrecyclerview.controller.HorizontalOverlapDecorator;
import com.abed.hexagonrecyclerview.controller.VerticalOverlapDecorator;


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

        float horizontal_spacing = typedArray.getDimension(R.styleable.HexagonRecyclerView_items_horizontal_spacing, 0.0f);
        float vertical_spacing = typedArray.getDimension(R.styleable.HexagonRecyclerView_items_vertical_spacing, 0.0f);
        final int row_size = typedArray.getInt(R.styleable.HexagonRecyclerView_items_count_in_row, 2);
        int orientation = typedArray.getInt(R.styleable.HexagonRecyclerView_orientation, 0);
        typedArray.recycle();


        if (row_size < 2)
            throw new RuntimeException("Hexagon RecyclerView row_size can't be smaller than 2");
        //the number of items in two consequetive rows
        final int itemsInTwoRows = row_size * 2 - 1;
        //There are two types of rows: big row and small row. Small row has one item less than the big row.
        final int itemsCountInSmallRow = row_size - 1;

        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), row_size * itemsCountInSmallRow);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position % itemsInTwoRows >= 0) && (position % itemsInTwoRows <= itemsCountInSmallRow - 1))
                    return row_size;
                return itemsCountInSmallRow;
            }
        });

        setLayoutManager(mLayoutManager);

        if (orientation == 0) {
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            addItemDecoration(new HorizontalOverlapDecorator(row_size, horizontal_spacing, vertical_spacing));
        } else {
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            addItemDecoration(new VerticalOverlapDecorator(row_size, horizontal_spacing, vertical_spacing));
        }
    }
}
