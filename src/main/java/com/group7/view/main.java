package com.group7.view;


import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class main {

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        ViewController gameWindow = new ViewController();

        gameWindow.drawPlayerEntry();

    }
}
