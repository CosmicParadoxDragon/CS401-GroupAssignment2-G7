package com.group7.view;

import javax.swing.*;
import java.awt.*;

public class CardTabs {
    private JButton btnCardTab;
    private JPanel panelCardTab;
    private JProgressBar pbCardColor;

    public CardTabs(String inCardTitle){

        btnCardTab.setText(inCardTitle);

        //pbCardColor.setBackground(Color.BLUE);

    }

    public JPanel getPanel(){
        return panelCardTab;
    }



}


