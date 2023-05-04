package com.group7.view;

import com.group7.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoView {


    //private Card curViewCard;

    String cardLocation;
    private int cardIndex;

    private CardViewer cardViewerObj;
    private int victoryPoints = 0;
    private int soil = 0;
    private int sprouts = 0;
    private int trunks = 0;

    private ViewController thisView;

    private Dimension leftDimen;

    private String curStatusText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi quis iaculis metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";

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
    private JButton btnPrompt1;

    private Controller controller;


    public InfoView(ViewController inThisView, Controller inControl){
        thisView = inThisView;
        controller = inControl;

        lblImageMtn.setIcon(new ImageIcon("src/main/java/com/group7/view/images/mtnIcont.png"));

        cardViewerObj = new CardViewer(inThisView, "NULL", 0);


        leftDimen = new Dimension(thisView.leftPanelWidth,thisView.leftPanelHeight);

        panelInfoView.setPreferredSize(leftDimen);

        taGameStatus.setLineWrap(true);
        taGameStatus.setWrapStyleWord(true);

        btnPrompt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.promptDeactivate();
                thisView.sfx.ping();
                controller.waiter.countDown();
            }
        });
    }

    void setCurViewCard(String inCardLocation, int inCardIndex){

        cardLocation = inCardLocation;
        cardIndex = inCardIndex;

        //cardViewerObj.setNewCard(cardLocation, cardIndex);

        cardViewerObj = new CardViewer(thisView, cardLocation, cardIndex);
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

        if(thisView.promptActive){
            btnPrompt1.setVisible(thisView.getCurPrompt().infoButton);
            btnPrompt1.setText(thisView.getCurPrompt().infoButtonText);
        }

        //refresh card view
        //cardViewerObj.setNewCard(cardLocation, cardIndex);

        if(!cardViewerObj.isEmpty()){
            cardViewerObj = new CardViewer(thisView, cardLocation,cardIndex);
        }
        panelCLCardView.removeAll();
        panelCLCardView.add(cardViewerObj.getPanel());
        panelCLCardView.repaint();
        panelCLCardView.revalidate();
        cardViewerObj.getPanel().setPreferredSize(leftDimen);
    }

    public void setCurStatusText(String inStat){
        curStatusText = inStat;

        refresh();
    }
}


