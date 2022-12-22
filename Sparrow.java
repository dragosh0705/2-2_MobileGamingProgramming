package com.example.week11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;

import java.util.Random;

public class Sparrow {
    private int scrW, scrH;
    private RectF rect = new RectF();

    private int speed;
    private PointF dir = new PointF();

    private float animTime;
    private float animSpan = 0;
    private int animNum = 0;

    private Bitmap[] arrBirds = new Bitmap[6];

    public float x,y;
    public int w,h;

    public Bitmap bird;
    public int ang = 0;
    public boolean isDead;

    public Sparrow(int width, int height) {
        scrW = width;
        scrH = height;

        bird = CommonResources.arBirds[0];
        w = CommonResources.bw;
        h = CommonResources.bh;


        intSparrow();
    }

    private void makeSprite(Context context) {
        Bitmap org = BitmapFactory.decodeResource(context.getResources(), R.drawable.sparrow);

        int bw = org.getWidth() / 6;
        int bh = org.getHeight();

        for(int i=0; i<6; i++) {
            arrBirds[i] = Bitmap.createBitmap(org, bw * i, 0, bw, bh);
        }

        w = bw/2;
        h = bh/2;

        bird = arrBirds[0];
    }

    private void intSparrow() {
        Random rnd = new Random();

        speed = rnd.nextInt(101) + 700;
        animTime = 0.85f - speed / 1000f;

        dir.x = speed;
        dir.y = 0;

        x = -w*2;
        y = rnd.nextInt(scrH - 500) + 100;
    }

    public void update(){
        x += dir.x * Time.deltaTime;
        y += dir.y * Time.deltaTime;

        animationBird();
        if(x > scrW + w || y > scrH + h ) {
            isDead = true;
        }
    }

    private void animationBird() {
        animSpan += Time.deltaTime;

        if(dir.y > 0 || animSpan < animTime) return;

        animSpan = 0;
        animNum++;

        if(animNum >= 5) {
            animNum = 0;
        }

        bird = CommonResources.arBirds[animNum];
    }

    public boolean hitTest(float px, float py) {
        if(dir.y>0) return false;

        float dist = (px-x) *(px-x) + (py-y)*(py-y);

        if(dist < h*h*0.7f) {
            dir.y = speed;
            dir.x = 0;

            ang = 180;
        }

        return (dir.x==0);
    }
}
