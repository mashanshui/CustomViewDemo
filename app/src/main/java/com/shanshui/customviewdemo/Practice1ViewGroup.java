package com.shanshui.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * @author mashanshui
 * @date 2020/1/6 0006
 * @desc TODO
 */
public class Practice1ViewGroup extends RelativeLayout {
    Paint indicatorPaint = new Paint();
    Paint paint = new Paint();
    Practice1View practice1View;

    public Practice1ViewGroup(Context context) {
        super(context);
        init();
    }

    public Practice1ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        practice1View = new Practice1View(getContext());
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        practice1View.setLayoutParams(layoutParams);
        addView(practice1View);
        indicatorPaint.setStyle(Paint.Style.FILL);
        indicatorPaint.setColor(getResources().getColor(R.color.colorPrimary));
        indicatorPaint.setStrokeWidth(Utils.dpToPixel(4));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#DDDDDD"));
        setWillNotDraw(false);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawRect(rect, paint);
        super.dispatchDraw(canvas);
        canvas.drawLine(canvas.getWidth() / 2, 0,
                canvas.getWidth() / 2, canvas.getHeight() * 6 / 10, indicatorPaint);
    }
}
