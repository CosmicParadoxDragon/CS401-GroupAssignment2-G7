package com.group7.view;

import javax.swing.*;
import java.awt.*;

public class GameInfo {

    ViewController thisView;
    private JPanel panelGameInfo;
    private JTextArea taStatusText;
    private JLabel labelPlaceholder;
    private JLabel labelPlaceholderVal;
    private JLabel labelPlantScoreVal;
    private JLabel lblGameInfoTitle;
    private JLabel lblCardViewTitle;
    private JPanel panelCLCardView;

    //scoring and text describing what's happening in game
    private String curStatusText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi quis iaculis metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.";

    private int plantScore = 0; //not sure what scoring vars we need, this is just a placeholder

    public GameInfo(ViewController inThisView){
        thisView = inThisView;
       // Dimension leftDimen = new Dimension(thisView.leftPanelWidth,thisView.leftPanelHeight);

       // panelGameInfo.setPreferredSize(leftDimen);
        taStatusText.setLineWrap(true);



    }

    /*
    void setCardViewPanel(JPanel inCardView){
        thisView.changePanel(panelCLCardView, inCardView);
    }

     */

    public void refresh(){
        taStatusText.setText(curStatusText);
        labelPlantScoreVal.setText(String.valueOf(plantScore));

    }

    public JPanel getPanel(){
        return (panelGameInfo);
    }
    /*
    public static JPanel getPanel(ViewController inThisView){
        GameInfo ret = new GameInfo(inThisView);
        return (ret.panelGameInfo);
    }

     */

}
