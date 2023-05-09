package com.group7.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.group7.controller.Controller;
import com.group7.model.cards.Card;
import com.group7.model.Player;

//Don't look in here. The code is great bro I promise

public class TableauView {

    private Player curPlayer;
    private Controller controller;
    private ViewController thisView;

    ArrayList<CardViewer> tableauCards = new ArrayList<CardViewer>();
    ArrayList<JPanel> tableauPanels = new ArrayList<JPanel>();


    //Creating forms en masse would've been annoying and I didn't want to
    private JPanel panelCLTableau1;
    private JPanel panelCLTableau2;
    private JPanel panelCLTableau3;
    private JPanel panelCLTableau4;
    private JPanel panelCLTableau5;
    private JPanel panelCLTableau6;
    private JPanel panelCLTableau7;
    private JPanel panelCLTableau8;
    private JPanel panelCLTableau9;
    private JPanel panelCLTableau10;
    private JPanel panelCLTableau11;
    private JPanel panelCLTableau12;
    private JPanel panelCLTableau13;
    private JPanel panelCLTableau14;
    private JPanel panelCLTableau15;
    private JPanel panelCLTableau16;
    private JPanel panelTableauContainer;

    private Dimension tableauCardSize;

    Dimension panelSize;

    public TableauView(ViewController inThisView, Controller inControl){

        thisView = inThisView;
        controller = inControl;

        curPlayer = inControl.getGame().getActivePlayer();

        tableauCardSize = new Dimension(thisView.tableauCardWidth, thisView.tableauCardHeight);

    }

    public void refresh(){
        //it's just a prank bro
        //camera's over there
        tableauPanels.clear();
        tableauCards.clear();

        tableauPanels.add(panelCLTableau1);
        tableauPanels.add(panelCLTableau2);
        tableauPanels.add(panelCLTableau3);
        tableauPanels.add(panelCLTableau4);
        tableauPanels.add(panelCLTableau5);
        tableauPanels.add(panelCLTableau6);
        tableauPanels.add(panelCLTableau7);
        tableauPanels.add(panelCLTableau8);
        tableauPanels.add(panelCLTableau9);
        tableauPanels.add(panelCLTableau10);
        tableauPanels.add(panelCLTableau11);
        tableauPanels.add(panelCLTableau12);
        tableauPanels.add(panelCLTableau13);
        tableauPanels.add(panelCLTableau14);
        tableauPanels.add(panelCLTableau15);
        tableauPanels.add(panelCLTableau16);

        for (int i = 0; i < 16; i++) {
            tableauCards.add(new CardViewer(thisView, "TABLEAU", i));

            tableauCards.get(i).setMiniCard();
            setTableauCardPanel(tableauPanels.get(i), tableauCards.get(i));

            tableauPanels.get(i).setMinimumSize(tableauCardSize);
            tableauPanels.get(i).setMaximumSize(tableauCardSize);
        }
    }

    private void setTableauCardPanel(JPanel tabPanel, CardViewer cardPanel){

        tabPanel.removeAll();
        tabPanel.add(cardPanel.getPanel());
        tabPanel.repaint();
        tabPanel.revalidate();
    }

    JPanel getPanel(){
        return (panelTableauContainer);
    }
}
