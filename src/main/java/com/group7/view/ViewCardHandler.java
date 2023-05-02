package com.group7.view;

import com.group7.model.Player;
import com.group7.model.cards.Card;

import javax.swing.text.View;
import java.util.ArrayList;

public class ViewCardHandler {

    private ViewController thisView;
    private Player curActivePlayer;

    public ArrayList<Card> viewCardsInHand = new ArrayList<Card>();
    public ArrayList<Card> viewCardsInTableau = new ArrayList<Card>();

    public ViewCardHandler(ViewController inThisView){
        thisView = inThisView;


    }
    public void loadCards(){

        viewCardsInTableau.clear();
        viewCardsInHand.clear();

        //gets cards from player tableau and dumps into one-dimensional array list
        //could be done in a way to preserve the two-dimensional array, but I want
        //compatibility with the hand card array

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    viewCardsInTableau.add(thisView.getViewActivePlayer().getPlayerTableau().getCard(i, j));
                }
            }

            for (int i = 0; i < thisView.getViewActivePlayer().getHand().size(); i++){
                viewCardsInHand.add(thisView.getViewActivePlayer().getHand().get(i));
            }

//            viewCardsInTableau.set(0, viewCardsInHand.get(0));
    }

    public ArrayList<Card> getViewCardsInHand(){
        return viewCardsInHand;
    }

    public ArrayList<Card> getViewCardsInTableau(){
        return viewCardsInTableau;
    }
}
