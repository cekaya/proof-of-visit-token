package com.example.proofofvisittoken.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proofofvisittoken.CoinElements.Coin;
import com.example.proofofvisittoken.CoinElements.Circle;
import com.example.proofofvisittoken.CoinElements.Dog;
import com.example.proofofvisittoken.R;
import com.example.proofofvisittoken.RandomNumberGenerator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText editCity, editName, editAbbreviaten;
    Button button_confirm;

    // is currently being changed by hand. for the colour of the coins you need
    int arrayIndex = 6;
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    String body = "";
    String tail = "";
    String eyes = "";
    String ears = "";
    String noise = "";

    Dog dog;
    Circle circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editAbbreviaten = (EditText) findViewById(R.id.editAbbreviaten);
        editCity = (EditText) findViewById(R.id.editCity);
        editName = (EditText) findViewById(R.id.editName);

        button_confirm = (Button) findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(this);

        dog = new Dog(this, body, ears, eyes, noise, tail);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_confirm:
                String name = editName.getText().toString();

                if (name.length() < 23) {
                    //body1
                    body = "bodyone";
                } else if (name.length() == 24) {
                    //body3
                    body = "bodyfour";
                } else if (name.length() < 32) {
                    //body2
                    body = "bodytwo";
                } else {
                    //body4
                    body = "bodythree";
                }

                if (name.contains("x")) {
                    //ears1
                    ears = "earsone";
                } else if (name.contains("y")) {
                    //ears2
                    ears = "earstwo";
                } else if (name.contains("z") || name.contains("v")) {
                    //ears3
                    ears = "earsthree";
                } else {
                    //ears4
                    ears = "earsfour";
                }

                if (name.contains("ä") || name.contains("(") || name.contains("(")) {
                    //eyes1
                    eyes = "eyesthree";
                } else if (name.contains("ö") || name.contains("ü")) {
                    //eyes2
                    eyes = "eyestwo";
                } else {
                    //eyes3
                    eyes = "eyesone";
                }

                String abbreviaten = editAbbreviaten.getText().toString();

                if (abbreviaten.length() < 3) {
                    //tail1
                    tail = "tailone";
                } else if (abbreviaten.length() == 3) {
                    //tail2
                    tail = "tailtwo";
                } else {
                    //tail3
                    tail = "tailthree";
                }

                String city = editCity.getText().toString();

                if (city.equals("Gelsenkirchen") || city.equals("Heidelberg")
                        || city.equals("Lübeck") || city.equals("Wiesbaden")) {
                    //noise1
                    noise = "noiseone";
                } else if (city.equals("Düsseldorf") || city.equals("Duisburg")
                        || city.equals("Hamburg") || city.equals("Erfurt")
                        || city.equals("Dresden") || city.equals("Nürnberg")
                        || city.equals("Bremen") || city.equals("Bonn")) {
                    //noise2
                    noise = "noisetwo";
                } else if (city.equals("Köln") || city.equals("Essen") || city.equals("Aachen")
                        || city.equals("Bocholt") || city.equals("Frankfurt am Main")
                        || city.equals("Stuttgart") || city.equals("Leipzig")
                        || city.equals("Regensburg")) {
                    //noise3
                    noise = "noisethree";
                } else if (city.equals("Berlin") || city.equals("Hannover")
                        || city.equals("Recklinghausen") || city.equals("Bochum")
                        || city.equals("Glattbeck") || city.equals("Münster")
                        || city.equals("Wuppertal") || city.equals("Bielefeld")) {
                    //noise4
                    noise = "noisefour";
                } else {
                    //noise5
                    noise = "noisefive";
                }

                dog = new Dog(this, body, ears, eyes, noise, tail);

                int diameter = dog.circleSize();
                int colorID = randomNumberGenerator.generateRandomNumber(arrayIndex);
                circle = new Circle(this, diameter, colorID);

                Coin coin = new Coin(this, circle, dog);
                setContentView(coin);
                break;
        }
    }
}
