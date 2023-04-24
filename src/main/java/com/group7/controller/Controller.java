
package com.group7.controller;

import com.group7.model.Game;
import com.group7.model.cards.Card;
import com.group7.view.gameTui;
import com.group7.model.cards.Card;

import java.io.IOException;


public class Controller {
    Game m_game;
    gameTui m_tui;

    public Controller() throws IOException {
        m_game = new Game(this, 1);
        // m_tui = new gameTui(this);//this);
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
        Card card;
        // This is the ideal production use case for this function, being handed a card object that 
        // the user selected from the hand based in the UI.
        // card = m_tui.getCardChoice(); // Need some way to limit choice to a specific vector of cards 
        // System.out.print("Enter a card number to discard: ");

        // this is a unplayable line that should not be included in a final release, but serves 
        // for testing purposes, as a way to discard in auto/test mode builds
        card = getGame().getActivePlayer().getHand().get(0);


        return card;


    }
}