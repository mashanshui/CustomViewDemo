package com.shanshui.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.math.BigDecimal;

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
    private Paint titlePaint;
    private Paint sizePaint;
    private int mmGap = (int) Utils.dpToPixel(12);
    private float currentNum = 0;
    private GestureDetector mDetector;
    private static final int scrollDistance = 6;

    public Practice1View(Context context) {
        this(context, null);
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mDetector = new GestureDetector(getContext(), gestureListener);
        currentNum = 60.0f;
        tvSelectNum = new TextView(getContext());
        tvSelectNum.setTextColor(getResources().getColor(R.color.colorPrimary));
        tvSelectNum.setTextSize(28);
        cmPaint = new Paint();
        cmPaint.setStrokeWidth(Utils.dpToPixel(2));
        cmPaint.setColor(Color.GRAY);
        mmPaint = new Paint();
        mmPaint.setStrokeWidth(Utils.dpToPixel(1));
        mmPaint.setColor(Color.GRAY);
        titlePaint = new Paint();
        titlePaint.setColor(getResources().getColor(R.color.colorPrimary));
        titlePaint.setTextSize(Utils.sp2px(36));
        titlePaint.setTextAlign(Paint.Align.CENTER);
        sizePaint = new Paint();
        sizePaint.setTextSize(Utils.sp2px(18));
        sizePaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(0, getHeight() / 2, getWidth(), getHeight());
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#DDDDDD"));
        canvas.drawRect(rect, paint);
        Log.e(TAG, "onDraw:1 " + rect.toString());
        int mmCount = getWidth() / 2 / mmGap;
        int firstOffset = getWidth() / 2 - mmCount * mmGap;
        for (int i = 0; i < mmCount * 2 + 1; i++) {
            int startX = i * mmGap + firstOffset;
            int startY = rect.top;
            int endX = startX;
            int endY;
            BigDecimal b1 = new BigDecimal(Float.toString(currentNum));
            BigDecimal b2 = new BigDecimal(Float.toString((mmCount - i) * 0.1f));
            float num = b1.subtract(b2).floatValue();
            if (Utils.isInt(num)) {
                endY = rect.height() / 2 + rect.top;
                canvas.drawLine(startX, startY, endX, endY, cmPaint);
                String size = String.valueOf((int) num);
                canvas.drawText(size, startX, endY + Utils.dpToPixel(32), sizePaint);
            } else {
                endY = rect.height() / 3 + rect.top;
                canvas.drawLine(startX, startY, endX, endY, mmPaint);
            }
        }
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        paint.setStrokeWidth(Utils.dpToPixel(4));
        canvas.drawLine(rect.width() / 2, rect.top,
                rect.width() / 2, rect.top + rect.height() * 6 / 10, paint);

        canvas.drawText(String.valueOf(currentNum), rect.width() / 2, rect.top - Utils.dpToPixel(16), titlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        return mDetector.onTouchEvent(event);
    }

    private GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            Log.e(TAG, "onDown: ");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e(TAG, "onScroll: ");
            if (e2.getX() - e1.getX() >= mmGap) {
                Log.e(TAG, "onScroll:1 " + currentNum);
                BigDecimal b1 = new BigDecimal(Float.toString(currentNum));
                BigDecimal b2 = new BigDecimal(Float.toString(0.1f));
                currentNum = b1.subtract(b2).floatValue();
                Log.e(TAG, "onScroll:2 " + currentNum);
            } else if (e1.getX() - e2.getX() >= mmGap){
                Log.e(TAG, "onScroll:1 " + currentNum);
                BigDecimal b1 = new BigDecimal(Float.toString(currentNum));
                BigDecimal b2 = new BigDecimal(Float.toString(0.1f));
                currentNum = b1.add(b2).floatValue();
                Log.e(TAG, "onScroll:2 " + currentNum);
            }
            invalidate();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };
}
