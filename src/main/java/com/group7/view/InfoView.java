package com.group7.view;

import javax.swing.*;
import java.awt.*;

public class InfoView {


    //panel elements

    private JPanel panelInfoView;
    private JTextArea taGameStatus;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;
    private JPanel panelCLCardView;
    private JLabel lblSoil;
    private JLabel lblSoilVal;
    private JLabel lblTrunks;
    private JLabel lblTrunksVal;
    private JLabel lblSprouts;
    private JLabel lblSproutsVal;
    private JPanel panelGameStatusContainer;
    private JLabel lblImageMtn;


    private CardViewer cardViewerObj;
    private int victoryPoints = 0;
    private int soil = 0;
    private int sprouts = 0;
    private int trunks = 0;

    private ViewController thisView;

    private Dimension leftDimen;

    private String curStatusText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi quis iaculis metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";

    public InfoView(ViewController inThisView){
        lblImageMtn.setIcon(new ImageIcon("src/main/java/com/group7/view/images/mtnIcont.png"));

        cardViewerObj = new CardViewer(inThisView);

        thisView = inThisView;
        leftDimen = new Dimension(thisView.leftPanelWidth,thisView.leftPanelHeight);

        panelInfoView.setPreferredSize(leftDimen);

        taGameStatus.setLineWrap(true);
        taGameStatus.setWrapStyleWord(true);


    }

    JPanel getPanel(){
        return panelInfoView;
    }

    void refresh(){
        taGameStatus.setText(curStatusText);
        lblVictoryPointsVal.setText(String.valueOf(victoryPoints));
        lblSoilVal.setText(String.valueOf(soil));
        lblSproutsVal.setText(String.valueOf(sprouts));
        lblTrunksVal.setText(String.valueOf(trunks));


        //refresh card view
        panelCLCardView.removeAll();
        panelCLCardView.add(cardViewerObj.getPanel());
        panelCLCardView.repaint();
        panelCLCardView.revalidate();
        cardViewerObj.getPanel().setPreferredSize(leftDimen);
    }
}


