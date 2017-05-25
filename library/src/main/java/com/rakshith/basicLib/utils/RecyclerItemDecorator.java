package com.rakshith.basicLib.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Rakshith on 3/7/17.
 */
public class RecyclerItemDecorator extends RecyclerView.ItemDecoration {
    int paddingLeft;
    int paddingRight;
    int paddingTop;
    int paddingBottom;
    Boolean isStoryHasHeroImage;

    public RecyclerItemDecorator(boolean isStoryHasHeroImage, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        this.paddingTop = paddingTop;
        this.paddingBottom = paddingBottom;
        this.isStoryHasHeroImage = isStoryHasHeroImage;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(isStoryHasHeroImage) {
            if (parent.getChildLayoutPosition(view) != 0) {
                if (parent.getChildLayoutPosition(view) == 1) {
                    outRect.top = paddingTop;
                }
                outRect.left = paddingLeft;
                outRect.right = paddingRight;
                outRect.bottom = paddingBottom;
            }
        }else{
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = paddingTop;
            }
            outRect.left = paddingLeft;
            outRect.right = paddingRight;
            outRect.bottom = paddingBottom;
        }
    }
}
