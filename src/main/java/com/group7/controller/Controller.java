
package com.group7.controller;

import com.formdev.flatlaf.FlatDarkLaf;
import com.group7.model.Game;
import com.group7.model.cards.Card;
import com.group7.view.ViewController;
import com.group7.view.*;
import com.group7.model.cards.Card;

import java.io.IOException;


public class Controller {
    Game m_game;
    //gameTui m_tui;

    ViewController m_gui;

    public Controller() throws IOException {
        m_game = new Game(this, 1);

        FlatDarkLaf.setup(); //initialize gui theme

        m_gui = new ViewController(this);

        m_gui.drawPlayerEntry();
    }

    public Game getGame() {
        return m_game;
    }


    public String getActionChoice()
    {
        String action = "planting";
        // Assumeing planting for testing and progression purposes
        // m_tui.promptForActionChoice();

        return action;
    }
    public Card getCardChoice()
    {
        Card someCard;
        // This is the ideal production use case for this function, being handed a card object that 
        // the user selected from the hand based in the UI.
        // card = m_tui.getCardChoice(); // Need some way to limit choice to a specific vector of cards 
        // System.out.print("Enter a card number to discard: ");

        // this is a unplayable line that should not be included in a final release, but serves 
        // for testing purposes, as a way to discard in auto/test mode builds

        someCard = getGame().getActivePlayer().getHand().get(0);


        return someCard;


    }
}