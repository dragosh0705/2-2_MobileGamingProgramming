package com.example.week11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CommonResources {
    static public Bitmap[] arBirds = new Bitmap[6];
    static public int bw;
    static public int bh;

    static public void set(Context context){
        Bitmap org = BitmapFactory.decodeResource(context.getResources(), R.drawable.sparrow);
        bw = org.getWidth()/6;
        bh = org.getHeight();

        for(int i=0; i<6; i++) {
            arBirds[i] = Bitmap.createBitmap(org, bw*i, 0, bw, bh);
        }
        bw /= 2;
        bh/= 2;
    }
}
