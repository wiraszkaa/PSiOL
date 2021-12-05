package com.example.jakubwiraszka.lab8;

public class Main {

    public static void main(String[] args) {
        UrlParser urlParser = new UrlParser();
        urlParser.parseUrl("https://mydomain.com/page?argument1={hard}&argument2={easy}");
    }
}
