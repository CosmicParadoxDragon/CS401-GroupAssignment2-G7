package com.group7.view;

import com.group7.model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardTabs {

    int cardIndex;
    Card curCard;

    private ViewController thisView;
    private JButton btnCardTab;
    private JPanel panelCardTab;
    private JProgressBar pbCardColor;
    private JToolBar.Separator cardSep;


    public CardTabs(int inCardIndex, ViewController inThisView){

        thisView = inThisView;
        cardIndex = inCardIndex;


        //curCard = thisView.getViewCardsInHand().get(cardIndex);
        curCard = thisView.getViewCards().getViewCardInHand(inCardIndex);

        btnCardTab.setText(curCard.getName());

        if(thisView.getViewCards().getHandCheckboxState(cardIndex)) {
            pbCardColor.setBackground(Color.lightGray);
        }

        if (cardIndex == 0){
            cardSep.setVisible(false);
        }


        //set tab color??

        btnCardTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.cardFlip();
                thisView.setViewCard("HAND", cardIndex);
            }
        });
    }

    public CardTabs(boolean isIslandClimate, int cardIndex, ViewController inThisView){
        thisView = inThisView;
        pbCardColor.setVisible(false);
        cardSep.setVisible(false);

        curCard = thisView.getViewCards().getViewCardIslCli(cardIndex);

        if(curCard != null) {
            btnCardTab.setText(curCard.getName());
        }else {
            btnCardTab.setText("N/A");
        }

        btnCardTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.cardFlip();
                thisView.setViewCard("ISLANDCLIMATE", cardIndex);
            }
        });
    }

    //blank card tab
    public CardTabs(){
        btnCardTab.setVisible(false);
        pbCardColor.setVisible(false);
        cardSep.setVisible(false);
    }

    public JPanel getPanel(){
        return panelCardTab;
    }


}


