// This contains a running instance of the game.
package com.group7.controller;

import com.group7.view.gameTui;
// import com.group7.Model.Cards.Card;


import java.io.IOException;

public final class Main {
    public static void main(String[] args) {
        
        // Game currentGame = new Game(1);

        // System.out.println("Hello, Maven!");

        // gameTui Interface = new gameTui(currentGame);
        try {
            Controller controller = new Controller();

        } catch (IOException e)
        {

        }
        catch (Exception e)
        {
            
        }

    }
}


