package com.shanshui.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author mashanshui
 * @date 2019/12/25 0025
 * @desc TODO
 */
public class BasicView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BasicView(Context context) {
        super(context);
    }

    public BasicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawCircle(300, 300, 200, paint);
//        canvas.drawRect(500, 500, 800, 600, paint);
//        canvas.drawPoint(500, 500, paint);
//        RectF rectF = new RectF(50, 50, 350, 200);
//        canvas.drawOval(rectF, paint);
        canvas.drawLine(100, 100, 500, 500, paint);
    }
}
