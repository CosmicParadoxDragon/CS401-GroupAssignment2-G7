package com.group7.view;

import javax.swing.*;

public class HandCards {
    private JPanel panelCardTabs;
    private JPanel panelCardContainer;

    //private JTabbedPane cardTabs;
    //private JPanel panelCLEmpty;

    //private ArrayList<JTabbedPane> cardTabs = new ArrayList<JTabbedPane>();

    public HandCards(ViewController thisView){

        //tbCardBar.add(new CardTabs("Card Title").getPanel());

        panelCardTabs.add(new CardTabs("Card Title").getPanel());
        for (int i = 0; i < 12; i++){
            panelCardTabs.add(new CardTabs("Card Title").getPanel());
        }

        //panelCardTabs.add(cardTabs);


    }
    public JPanel getPanel(){
        return (panelCardTabs);
    }
}



