package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CirculeView extends View {
    public CirculeView(Context context) {
        super(context);
    }

    public CirculeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        //画红色实心圆
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        int r = getMeasuredWidth()/2;
        int centerX = getLeft()+r;
        int centerY = getTop()+r;
        canvas.drawCircle(centerX,centerY,r,paint);
    }
}

