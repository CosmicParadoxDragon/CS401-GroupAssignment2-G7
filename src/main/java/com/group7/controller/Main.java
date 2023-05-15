// This contains a running instance of the game.
package com.group7.controller;

import com.formdev.flatlaf.FlatDarkLaf;

// import com.group7.view.
// import com.group7.model.Cards.Card;


import java.io.IOException;

public final class Main extends Thread{
    public static void main(String[] args) throws IOException {



       //  Game currentGame = new Game(1);
       //
       //  System.out.println("Hello, Maven!");
       //
       //  gameTui Interface = new gameTui(currentGame);
        Controller game_controller = new Controller("game");
       //  try {
       // Controller tutorial_controller = new Controller();
       //
       //
       //
       //
       // new Thread("GameThread") {
       //     @Override public void run () { controller.getGame().GameStart(); }
       // }.start();
       //
       //
       //  } catch (IOException e)
       //  {
       //
       //  }
       //  catch (Exception e)
       //  {
       //     System.out.println(e.getStackTrace());
       //  }

    }
}


