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
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.OverScroller;
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
    //最小最大刻度值(以0.1kg为单位)
    private int mMinScale = 464, mMaxScale = 2000;
    private Paint cmPaint;
    private Paint mmPaint;
    private Paint sizePaint;
    private int mmGap = (int) Utils.dpToPixel(12);
    private float currentNum = 0;
    private VelocityTracker velocityTracker;
    private OverScroller overScroller;
    private static final int scrollDistance = 6;
    private int mMaximumVelocity, mMinimumVelocity;

    public Practice1View(Context context) {
        this(context, null);
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        velocityTracker = VelocityTracker.obtain();
        overScroller = new OverScroller(getContext());
        mMaximumVelocity = ViewConfiguration.get(getContext())
                .getScaledMaximumFlingVelocity();
        mMinimumVelocity = ViewConfiguration.get(getContext())
                .getScaledMinimumFlingVelocity();
        currentNum = 60.0f;
        cmPaint = new Paint();
        cmPaint.setStrokeWidth(Utils.dpToPixel(2));
        cmPaint.setColor(Color.GRAY);
        mmPaint = new Paint();
        mmPaint.setStrokeWidth(Utils.dpToPixel(1));
        mmPaint.setColor(Color.GRAY);
        sizePaint = new Paint();
        sizePaint.setTextSize(Utils.sp2px(18));
        sizePaint.setTextAlign(Paint.Align.CENTER);
        //第一次进入，跳转到当前刻度
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                goToScale(mCurrentScale);
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = mMinScale; i < mMaxScale; i++) {
            int startX = (i - mMinScale) * mmGap;
            int startY = 0;
            int endX = startX;
            int endY;
            if (i % 10 == 0) {
                endY = getHeight() / 2;
                canvas.drawLine(startX, startY, endX, endY, cmPaint);
                canvas.drawText(String.valueOf(i / 10), startX, endY + Utils.dpToPixel(32), sizePaint);
            } else {
                endY = getHeight() / 3;
                canvas.drawLine(startX, startY, endX, endY, mmPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return true;
    }
}
