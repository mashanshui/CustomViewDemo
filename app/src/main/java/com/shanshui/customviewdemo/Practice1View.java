package com.shanshui.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @author mashanshui
 * @date 2020/1/2 0002
 * @desc TODO
 */
public class Practice1View extends View {
    private static final String TAG = "Practice1View";
    private TextView tvSelectNum;
    private Paint paint = new Paint();
    private Paint cmPaint;
    private Paint mmPaint;
    private int mmGap = (int) Utils.dpToPixel(6);
    private float currentNum = 0;

    public Practice1View(Context context) {
        this(context, null);
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        tvSelectNum = new TextView(getContext());
        tvSelectNum.setTextColor(Color.GREEN);
        tvSelectNum.setTextSize(28);
        cmPaint = new Paint();
        cmPaint.setStrokeWidth(Utils.dpToPixel(2));
        cmPaint.setColor(Color.GRAY);
        mmPaint = new Paint();
        mmPaint.setStrokeWidth(Utils.dpToPixel(1));
        mmPaint.setColor(Color.GRAY);
        currentNum = 60;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(0, getHeight() / 2, getWidth(), getHeight());
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(Utils.dpToPixel(4));
        canvas.drawLine(rect.width() / 2, rect.top,
                rect.width() / 2, rect.top + rect.height() / 2, paint);
        Log.e(TAG, "onDraw:1 " + rect.toString());
        int mmCount = getWidth() / mmGap;
        for (int i = 0; i < mmCount; i++) {
            int startX = i * mmGap;
            int startY = rect.top;
            int endX = startX;
            int endY;
            if () {
                canvas.drawLine(startX, startY, endX, endY, mmPaint);
            } else {
                canvas.drawLine(startX, startY, endX, endY, cmPaint);
            }
        }
    }
}