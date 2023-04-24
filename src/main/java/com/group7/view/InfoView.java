package com.group7.view;

import javax.swing.*;
import java.awt.*;

public class InfoView {


    private JPanel panelInfoView;
    private JLabel lblInfoTitle;
    private JTextArea taGameStatus;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;
    private JLabel lblCardViewTitle;
    private JPanel panelCLCardView;


    private CardViewer cardViewerObj;
    private int victoryPoints = 0;
    private ViewController thisView;

    private Dimension leftDimen;

    private String curStatusText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi quis iaculis metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";

    public InfoView(ViewController inThisView){
        cardViewerObj = new CardViewer();

        thisView = inThisView;
        leftDimen = new Dimension(thisView.leftPanelWidth,thisView.leftPanelHeight);

        panelInfoView.setPreferredSize(leftDimen);

        taGameStatus.setLineWrap(true);


    }

    JPanel getPanel(){
        return panelInfoView;
    }

    void refresh(){
        taGameStatus.setText(curStatusText);
        lblVictoryPointsVal.setText(String.valueOf(victoryPoints));

        //refresh card


        cardViewerObj.getPanel().setPreferredSize(leftDimen);
        panelCLCardView.removeAll();
        panelCLCardView.add(cardViewerObj.getPanel());
        panelCLCardView.repaint();
        panelCLCardView.revalidate();
    }
}


