package com.group7.view;

import javax.swing.*;

import com.group7.controller.Controller;
import com.group7.model.Player;
import com.group7.model.cards.Card;

import java.util.ArrayList;

//The container for cards being held in the current player's hand

public class HandCards {

    private ViewController thisView;
    private Controller controller;
    private Player curPlayer;

    private ArrayList<Card> cardsInHand;

    private JPanel panelCardTabs;
    private JPanel panelCardContainer;


    public HandCards(ViewController inThisView, Controller inControl){

        thisView = inThisView;
        controller = inControl;


        //I'm completely stumped as to why, but unless I add a cardtab outside
        //of the loop first, I can't add any within the loop. It started happening when I created
        //ViewCardHandler. Will investigate more later, but for now this works.

        panelCardTabs.add(new CardTabs().getPanel());

            for (int i = 0; i < thisView.getViewCardsInHand().size(); i++) {
                panelCardTabs.add(new CardTabs(i, thisView).getPanel());
            }
    }
    public JPanel getPanel(){
        return (panelCardTabs);
    }
}



