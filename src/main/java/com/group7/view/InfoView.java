package com.group7.view;

import com.group7.model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoView {


    private Card curViewCard;
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


    public InfoView(ViewController inThisView){
        lblImageMtn.setIcon(new ImageIcon("src/main/java/com/group7/view/images/mtnIcont.png"));

        cardViewerObj = new CardViewer(inThisView, "NULL", 0);

        thisView = inThisView;
        leftDimen = new Dimension(thisView.leftPanelWidth,thisView.leftPanelHeight);

        panelInfoView.setPreferredSize(leftDimen);

        taGameStatus.setLineWrap(true);
        taGameStatus.setWrapStyleWord(true);

    }

    void setCurViewCard(String cardLocation, int cardIndex){
        switch (cardLocation){
            case "HAND":
                curViewCard = thisView.getViewCardsInHand().get(cardIndex);
            break;

            case "TABLEAU":
                curViewCard = thisView.getViewTableauCards().get(cardIndex);
                break;

            default:
                break;
        }
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
        cardViewerObj.setNewCard(curViewCard);
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


