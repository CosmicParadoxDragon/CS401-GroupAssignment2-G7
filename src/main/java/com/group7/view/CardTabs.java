package com.group7.view;

import javax.swing.*;

public class CardTabs {
    private JButton btnCardTab;
    private JPanel panelCardTab;

    public CardTabs(String inCardTitle){

        btnCardTab.setText(inCardTitle);

    }

    public JPanel getPanel(){
        return panelCardTab;
    }
}


