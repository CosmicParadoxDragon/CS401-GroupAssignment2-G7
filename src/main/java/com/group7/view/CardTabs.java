package com.group7.view;

import com.group7.model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.group7.view.sfx.sfxController;

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

        //debug
        curCard = thisView.getViewCardsInHand().get(cardIndex);

        btnCardTab.setText(curCard.getM_name());

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


