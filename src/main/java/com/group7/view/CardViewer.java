package com.group7.view;

import javax.swing.*;

public class CardViewer {
    private JPanel panelCardView;
    private JTextArea taCardAbility;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;
    private JButton btnViewCard;

    public CardViewer(ViewController thisView){

    }

    public CardViewer(){
        btnViewCard.setVisible(false);

    }

    void setMiniCard(){
        taCardAbility.setVisible(false);
        btnViewCard.setVisible(true);
    }

    JPanel getPanel(){
        return panelCardView;
    }
}
