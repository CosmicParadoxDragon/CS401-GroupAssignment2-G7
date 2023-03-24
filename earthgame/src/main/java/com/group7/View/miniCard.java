package com.group7.View;

import com.group7.Model.Cards.Card;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

public class miniCard {
    static int cardColSize = 19;
    static int cardRowSize = 8;
    Panel outerPanel = new Panel();
    Panel cardPanel = new Panel();

    public miniCard(){
        String name = "<empty slot>";
        String habitat = " ";
        int cost = 0;

        cardGen(name, habitat, cost);
    }

    public miniCard(Card curCard){
        String name = curCard.getM_name();
        String habitat = "habitat";
        int cost = 69;

        cardGen(name, habitat, cost);
    }

    void cardGen(String name, String habitat, int cost){
        outerPanel.setLayoutManager(new BorderLayout());
        cardPanel.addComponent(new Label(name));
        cardPanel.addComponent(new Label(habitat));
        cardPanel.addComponent(new Label(""));
        cardPanel.addComponent(new Label(""));
        cardPanel.addComponent(new Label(""));
        cardPanel.addComponent(new Button("   View Card   "));
        outerPanel.addComponent(cardPanel.withBorder(Borders.singleLine(name)));
        outerPanel.setSize(new TerminalSize(cardColSize, cardRowSize));
    }

    Panel getPanel(){
        return outerPanel;
    }

    void setCardPosition(int colPos, int rowPos){

        outerPanel.setPosition(new TerminalPosition(colPos,rowPos));

    }

    static int getCardColSize(){
        return cardColSize;
    }

    static int getCardRowSize(){
        return cardRowSize;
    }
}
