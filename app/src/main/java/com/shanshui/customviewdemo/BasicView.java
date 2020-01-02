package com.shanshui.customviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
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
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(20);
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawCircle(300, 300, 200, paint);
//        canvas.drawRect(500, 500, 800, 600, paint);
//        canvas.drawPoint(500, 500, paint);
//        RectF rectF = new RectF(50, 50, 350, 200);
//        canvas.drawOval(rectF, paint);
//        canvas.drawLine(100, 100, 500, 500, paint);
//        canvas.drawText("asasdsad", 100, 100, paint);
//        Shader shader = new LinearGradient(0, 0, 1000, 1000, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
//        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);
        canvas.save();
//        canvas.rotate(45,800,700);
//        canvas.translate(300,200);
//        canvas.clipRect(new RectF(100, 100, 500, 500));
//        canvas.scale(0.3f,0.3f);
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sss);
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(60);
        canvas.translate(bitmap.getHeight() / 2 + 300, bitmap.getWidth() / 2 + 300);
        camera.applyToCanvas(canvas);
        canvas.translate(-bitmap.getHeight() / 2 - 300, -bitmap.getWidth() / 2 - 300);
        camera.restore();
        canvas.drawBitmap(bitmap, 300, 300, new Paint());
        canvas.restore();

    }
}
