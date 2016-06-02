package com.abed.HexagonRecyclerView.controller;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by mindvalley on 31/05/2016.
 */

public class HorizontalOverlapDecorator extends RecyclerView.ItemDecoration {
    private int mSpaceHeight;
    private int mSpaceWidth;
    private final int mRowSize;

    public HorizontalOverlapDecorator(int rowSize, float mSpaceWidth, float mSpaceHeight) {
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
        int smallRow_padding_top_bottom = parent.getHeight() / (mRowSize * 2);
        // resize the items in the small row to make them equal to the items in big row by squeezing them
        int smallRow_padding_item_squeez = parent.getHeight() / (mRowSize * itemsCountInSmallRow);
//         smallRow_padding_item_squeez = 0;
        //shift the items so the interpolate
        int item_row_shift = -1 * (int) (smallRow_padding_top_bottom / Math.sqrt(3)) + mSpaceWidth;
        if (mRowSize > 3) {
            //Check if the item is the first item in a small row and pad it from top
            if ((position % itemsInTwoRows) == 0) {
                outRect.set(0,
                        smallRow_padding_top_bottom + mSpaceHeight / 2,
                        item_row_shift,
                        -1 * smallRow_padding_item_squeez + mSpaceHeight / 2);
                return;
            }
            //Check if the item is the last item in a small row and pad it from bottom
            else if ((position % itemsInTwoRows) == (itemsCountInSmallRow - 1)) {
                outRect.set(0,
                        -1 * smallRow_padding_item_squeez + mSpaceHeight / 2,
                        item_row_shift,
                        smallRow_padding_top_bottom + mSpaceHeight / 2);
                return;
            }
            //if the item is a middle item in a small row
            else if ((position % itemsInTwoRows > 0) && (position % itemsInTwoRows < itemsCountInSmallRow - 1)) {
                outRect.set(0,
                        smallRow_padding_item_squeez + mSpaceHeight / 2,
                        item_row_shift,
                        smallRow_padding_item_squeez + mSpaceHeight / 2);
                return;
            }
        } else if (mRowSize == 2) {
            if ((position % itemsInTwoRows) == 0) {
                outRect.set(0,
                        smallRow_padding_item_squeez + mSpaceHeight / 2,
                        item_row_shift,
                        smallRow_padding_item_squeez + mSpaceHeight / 2);
                return;
            }
        }

        //if the item is an item in a big row
        outRect.set(0,
                mSpaceHeight / 2,
                item_row_shift,
                mSpaceHeight / 2);

        return;


    }
}