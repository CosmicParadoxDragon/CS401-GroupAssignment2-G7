package com.group7.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.group7.model.cards.Card;

public class CardViewer {

    //panel elements
    private JPanel panelCardView;
    private JTextArea taCardAbility;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;
    private JButton btnViewCard;
    private JLabel lblCardTitle;

    private Card displayCard;

    private ViewController thisView;

    public CardViewer(ViewController inThisView, Card displayCard){
        thisView = inThisView;
        btnViewCard.setVisible(false);

        lblCardTitle.setText(displayCard.getM_name());


        btnViewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.cardFlip();
            }
        });
    }

    public CardViewer(ViewController inThisView){
        btnViewCard.setVisible(false);


    }

    //changes card to small tile. removes ability text box and adds a view card button
    void setMiniCard(){
        //taCardAbility.setVisible(false);
        btnViewCard.setVisible(true);
    }

    JPanel getPanel(){
        return panelCardView;
    }
}
