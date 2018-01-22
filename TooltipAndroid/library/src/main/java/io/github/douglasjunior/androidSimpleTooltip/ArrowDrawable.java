/*
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 Douglas Nassif Roma Junior
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.douglasjunior.androidSimpleTooltip;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;

/**
 * ArrowDrawable
 * Created by douglas on 09/05/16.
 */
public class ArrowDrawable extends ColorDrawable {

    public static final int LEFT = 0, TOP = 1, RIGHT = 2, BOTTOM = 3, AUTO = 4;

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int mBackgroundColor;
    private Path mPath;
    private Path mPathNotBorder;
    private final int mDirection;
    private int width;

    ArrowDrawable(@ColorInt int foregroundColor, int direction) {
        this.mBackgroundColor = Color.TRANSPARENT;
        this.mPaint.setColor(foregroundColor);
        this.mDirection = direction;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        updatePath(bounds);
    }

    private synchronized void updatePath(Rect bounds) {
        width = (int) SimpleTooltip.mArrowWidth;
        mPath = new Path();
        mPathNotBorder = new Path();
        int x = bounds.width() * 3 / 4 - width/2;

        switch (mDirection) {
            case LEFT:
                mPath.moveTo(bounds.width(), bounds.height());
                mPath.lineTo(0, bounds.height() / 2);
                mPath.lineTo(bounds.width(), 0);
                mPath.lineTo(bounds.width(), bounds.height());
                break;
            case TOP:
//                mPath.moveTo(0, bounds.height());
//                mPath.lineTo(bounds.width() / 2, 0);
//                mPath.lineTo(bounds.width(), bounds.height());
//                mPath.lineTo(0, bounds.height());
//                break;
                mPathNotBorder.moveTo(x, bounds.height());
                mPathNotBorder.lineTo(x + width/2, 0);
                mPathNotBorder.lineTo(x + width, bounds.height() + 1);
                mPathNotBorder.lineTo(x, bounds.height() + 1);
                break;
            case RIGHT:
                mPath.moveTo(0, 0);
                mPath.lineTo(bounds.width(), bounds.height() / 2);
                mPath.lineTo(0, bounds.height());
                mPath.lineTo(0, 0);
                break;
            case BOTTOM:
//                mPath.moveTo(0, 0);
//                mPath.lineTo(bounds.width() / 2, bounds.height());
//                mPath.lineTo(bounds.width(), 0);
//                mPath.lineTo(0, 0);
//                break;
                mPathNotBorder.moveTo(x, 0);
                mPathNotBorder.lineTo(x + width/2, bounds.height());
                mPathNotBorder.lineTo(x + width, 0);
                mPathNotBorder.lineTo(x, 0);
                break;
        }

        mPath.close();
    }

    @Override
    public void draw(Canvas canvas) {
        width = (int) SimpleTooltip.mArrowWidth;
        int x = canvas.getWidth() * 3 / 4 - width/2;

        canvas.drawColor(mBackgroundColor);
        if (mPath == null)
            updatePath(getBounds());
        canvas.drawPath(mPathNotBorder, mPaint);
        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(SimpleTooltip.mDefaultBorderColorRes);
        mPaint.setStrokeWidth(3);
        canvas.drawPath(mPath, mPaint);

        switch (mDirection) {
            case LEFT:
                break;
            case TOP:
                canvas.drawLine(SimpleTooltipUtils.pxFromDp(2.5f), canvas.getHeight() - 1, x, canvas.getHeight() - 1, mPaint);
                canvas.drawLine(x + width, canvas.getHeight() - 1, canvas.getWidth() - SimpleTooltipUtils.pxFromDp(2.5f), canvas.getHeight() - 1, mPaint);
                canvas.drawLine(x, canvas.getHeight() - 1, x + width/2, 0, mPaint);
                canvas.drawLine(x + width/2, 0, x + width, canvas.getHeight() - 1, mPaint);
                break;
            case RIGHT:
                break;
            case BOTTOM:
                canvas.drawLine(SimpleTooltipUtils.pxFromDp(2.5f), 1, x, 1, mPaint);
                canvas.drawLine(x + width, 1, canvas.getWidth() - SimpleTooltipUtils.pxFromDp(2.5f), 1, mPaint);
                canvas.drawLine(x, 1, x + width/2, canvas.getHeight(), mPaint);
                canvas.drawLine(x + width/2, canvas.getHeight(), x + width, 1, mPaint);
                break;
        }

    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    public void setColor(@ColorInt int color) {
        mPaint.setColor(color);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        if (mPaint.getColorFilter() != null) {
            return PixelFormat.TRANSLUCENT;
        }

        switch (mPaint.getColor() >>> 24) {
            case 255:
                return PixelFormat.OPAQUE;
            case 0:
                return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.TRANSLUCENT;
    }
}
