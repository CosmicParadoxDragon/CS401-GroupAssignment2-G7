package com.group7.view;

import javax.swing.*;

public class CardViewer {
    private JPanel panelCardView;
    private JTextArea taCardAbility;
    private JCheckBox checkboxAttributePlaceholder1;
    private JCheckBox aFalseAttributeCheckBox;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;

    public CardViewer(ViewController thisView){

    }

    public CardViewer(){

    }

    JPanel getPanel(){
        return panelCardView;
    }
}
