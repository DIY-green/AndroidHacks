/*
 * Copyright (C) 2016 jiashuangkuaizi, Inc.
 */
package com.diygreen.androidhackslayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.diygreen.androidhackslayout.R;

/**
 * Description:
 * <br/>Program Name:
 * <br/>Date: 2016年3月7日
 *
 * @author 李旺成
 * @version 1.0
 */

public class CascadeLayout extends ViewGroup {

    private int mHorizontalSpacing;
    private int mVerticalSpacing;

    public CascadeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CascadeLayout);

        try {
            mHorizontalSpacing = a.getDimensionPixelSize(
                    R.styleable.CascadeLayout_horizontal_spacing,
                    getResources().getDimensionPixelSize(
                            R.dimen.cascade_horizontal_spacing));

            mVerticalSpacing = a.getDimensionPixelSize(
                    R.styleable.CascadeLayout_vertical_spacing, getResources()
                            .getDimensionPixelSize(R.dimen.cascade_vertical_spacing));
        } finally {
            a.recycle();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 使用宽和高计算布局的最终大小以及子视图的 x 与 y 轴位置
        int width = getPaddingLeft();
        int height = getPaddingTop();
        int verticalSpacing;

        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            verticalSpacing = mVerticalSpacing;

            View child = getChildAt(i);
            // 让每个子视图测量自身
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            width = getPaddingLeft() + mHorizontalSpacing * i;

            // 在 LayoutParamas 中保存每个子视图的 x 和 y 坐标
            lp.x = width;
            lp.y = height;

            if (lp.verticalSpacing >= 0) {
                verticalSpacing = lp.verticalSpacing;
            }

            width += child.getMeasuredWidth();
            height += verticalSpacing;
        }

        width += getPaddingRight();
        height += getChildAt(getChildCount() - 1).getMeasuredHeight()
                + getPaddingBottom();

        // 使用计算所得的宽和高设置整个布局的测量尺寸
        setMeasuredDimension(resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();

            child.layout(lp.x, lp.y, lp.x + child.getMeasuredWidth(), lp.y
                    + child.getMeasuredHeight());
        }
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p.width, p.height);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int x;
        int y;
        public int verticalSpacing;

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);

            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.CascadeLayout_LayoutParams);
            try {
                verticalSpacing = a
                        .getDimensionPixelSize(
                                R.styleable.CascadeLayout_LayoutParams_layout_vertical_spacing,
                                -1);
            } finally {
                a.recycle();
            }
        }

        public LayoutParams(int w, int h) {
            super(w, h);
        }

    }
}
