package com.example.proofofvisittoken;

import java.util.Random;

public class RandomNumberGenerator{

    public int generateRandomNumber(int index){
        Random rnd = new Random(index);
        rnd.setSeed(index);
        return  rnd.nextInt(900000000)+100000000;
    }
}
