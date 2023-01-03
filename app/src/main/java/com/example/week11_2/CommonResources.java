package com.example.week11_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.week11.R;

public class CommonResources {
    static public Bitmap ball;
    static public int r = 80;
    static public void set(Context context) {
        ball = BitmapFactory.decodeResource(context.getResources(), R.drawable.ball);
        ball = Bitmap.createScaledBitmap(ball, r*2, r*1, true);
    }
}
