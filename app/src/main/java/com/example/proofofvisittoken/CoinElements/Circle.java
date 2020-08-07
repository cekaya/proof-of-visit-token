package com.example.proofofvisittoken.CoinElements;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

public class Circle extends View {
    Paint paint;
    int diameter;
    int color;

    public Circle(Context context, int diameter, int color) {
        super(context);
        this.diameter = diameter;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        paint = new Paint();
        setColor(this.color);

        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
        canvas.drawCircle(xPos, yPos, diameter, paint);
    }

    public void setColor(int color) {
        int red = color / 100000;
        int green = (color / 100) % 100;
        int blue = color % 100000;
        paint.setColor(Color.rgb(red, green, blue));
        paint.setAlpha(120);
    }

}
