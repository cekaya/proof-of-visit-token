package com.example.proofofvisittoken.CoinElements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.proofofvisittoken.BuildConfig;
import com.example.proofofvisittoken.Activities.MainActivity;

public class Dog extends View {

    Bitmap body;
    Bitmap ears;
    Bitmap eyes;
    Bitmap noise;
    Bitmap tail;

    final BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();


    public Dog(Context context) {
        super(context);
    }

    public Dog(Context context, String bodyDrawableName, String earsDrawableName, String eyesDrawableName,
               String noiseDrawableName, String tailDrawableName) {
        super(context);

        int bodyID = getResources().getIdentifier(bodyDrawableName, "drawable", BuildConfig.APPLICATION_ID);
        int earsID = getResources().getIdentifier(earsDrawableName, "drawable", BuildConfig.APPLICATION_ID);
        int eyesID = getResources().getIdentifier(eyesDrawableName, "drawable", BuildConfig.APPLICATION_ID);
        int noiseID = getResources().getIdentifier(noiseDrawableName, "drawable", BuildConfig.APPLICATION_ID);
        int tailID = getResources().getIdentifier(tailDrawableName, "drawable", BuildConfig.APPLICATION_ID);


        mBitmapOptions.inScaled = true;
        mBitmapOptions.inSampleSize = 7;

        body = BitmapFactory.decodeResource(getResources(), bodyID, mBitmapOptions);
        ears = BitmapFactory.decodeResource(getResources(), earsID, mBitmapOptions);
        eyes = BitmapFactory.decodeResource(getResources(), eyesID, mBitmapOptions);
        noise = BitmapFactory.decodeResource(getResources(), noiseID, mBitmapOptions);
        tail = BitmapFactory.decodeResource(getResources(), tailID,mBitmapOptions);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centreX = (canvas.getWidth()  - body.getWidth()) /2;
        int centreY = (canvas.getHeight() - body.getHeight()) /2;

        canvas.drawBitmap(body,centreX,centreY,null);
        canvas.drawBitmap(ears,centreX,centreY,null);
        canvas.drawBitmap(eyes,centreX,centreY,null);
        canvas.drawBitmap(noise,centreX,centreY,null);
        canvas.drawBitmap(tail,centreX,centreY,null);
    }

    public int circleSize(){
        int size = (body.getWidth()/3) + (body.getWidth() /3);
        return size;
    }



}