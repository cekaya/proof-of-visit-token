package com.example.proofofvisittoken.CoinElements;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.proofofvisittoken.CoinElements.Circle;
import com.example.proofofvisittoken.CoinElements.Dog;

public class Coin extends View {

    Circle circle;
    Dog dog;

    public Coin(Context context, Circle circle, Dog dog) {
        super(context);
        this.circle = circle;
        this.dog = dog;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        circle.draw(canvas);
        dog.draw(canvas);

    }

}
