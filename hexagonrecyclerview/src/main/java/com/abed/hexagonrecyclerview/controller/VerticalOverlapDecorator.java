package com.abed.hexagonrecyclerview.controller;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mindvalley on 31/05/2016.
 */

public class VerticalOverlapDecorator extends RecyclerView.ItemDecoration {
    private int mSpaceHeight;
    private int mSpaceWidth;
    private final int mRowSize;

    public VerticalOverlapDecorator(int rowSize, float mSpaceWidth, float mSpaceHeight) {
        this.mSpaceHeight = (int) mSpaceHeight;
        this.mSpaceWidth = (int) mSpaceWidth;
        this.mRowSize = rowSize;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        int itemsInTwoRows = mRowSize * 2 - 1;
        int itemsCountInSmallRow = mRowSize - 1;
        //pad the small row by half of the size of an item in the big row
        int smallRow_padding_top_bottom = parent.getWidth() / (mRowSize * 2);
        // resize the items in the small row to make them equal to the items in big row by squeezing them
        int smallRow_padding_item_squeez = parent.getWidth() / (mRowSize * itemsCountInSmallRow);
        //shift the items so the interpolate
        int item_row_shift =-1 * (int) (smallRow_padding_top_bottom / Math.sqrt(3)) + mSpaceHeight;

        double offset_up = 0;
        double offset_down = item_row_shift;
        double offset_left = 0;
        double offset_right = 0;


        double i = 1.5 * itemsCountInSmallRow - mRowSize;

        if (((position % itemsInTwoRows) >= 0) && ((position % itemsInTwoRows) < itemsCountInSmallRow)) {
            offset_left = (i - ((position % itemsInTwoRows) - 1)) * smallRow_padding_item_squeez;
            offset_right = ((position % itemsInTwoRows) - i) * smallRow_padding_item_squeez;

        }


        if ((position % itemsInTwoRows) == 0) {
            offset_left = smallRow_padding_top_bottom;
        }
        if ((position % itemsInTwoRows) == itemsCountInSmallRow - 1) {
            offset_right = smallRow_padding_top_bottom;
        }

        outRect.set((int) Math.ceil(offset_left + mSpaceWidth / 2),
                (int) Math.ceil(offset_up),
                (int) Math.ceil(offset_right + mSpaceWidth / 2),
                (int) Math.ceil(offset_down));

    }
}