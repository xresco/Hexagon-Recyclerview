package com.abed.HexagonRecyclerView.controller;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mindvalley on 31/05/2016.
 */

public class HorizontalOverlapDecorator extends RecyclerView.ItemDecoration {
    private final int mSpaceHeight;
    private final int mSpaceWidth;

    public HorizontalOverlapDecorator(int mSpaceWidth, int mSpaceHeight) {
        this.mSpaceHeight = mSpaceHeight;
        this.mSpaceWidth = mSpaceWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        switch (position % 3) {
            case 0:
                outRect.set(0, parent.getHeight() / 4, (int) (-1 * parent.getHeight() / 6.96) + mSpaceWidth, parent.getHeight() / 4);

                return;
            default:
                outRect.set(0, (int) (mSpaceHeight / 2.0), (int) (-1 * parent.getHeight() / 6.96) + mSpaceWidth, (int) (mSpaceHeight / 2.0));
                return;
        }

    }
}