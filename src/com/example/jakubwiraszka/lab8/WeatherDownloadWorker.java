package com.example.jakubwiraszka.lab8;

import java.util.Random;

public class WeatherDownloadWorker {

    public boolean downloadData() {   // JAK W KLASIE WeatherDownloader
        Random r = new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return r.nextInt(2) == 1;
    }
}
