package com.sunzn.menu.swipe.sample;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class LineDecoration extends RecyclerView.ItemDecoration {

    private int hSpacing;

    private int vSpacing;

    public LineDecoration(int spacing) {
        this(spacing, spacing);
    }

    public LineDecoration(int hSpacing, int vSpacing) {
        this.hSpacing = hSpacing < 0 ? 0 : hSpacing;
        this.vSpacing = vSpacing < 0 ? 0 : vSpacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = hSpacing;
        outRect.right = hSpacing;
        outRect.bottom = vSpacing;

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = vSpacing;
        } else {
            outRect.top = 0;
        }
    }
}
