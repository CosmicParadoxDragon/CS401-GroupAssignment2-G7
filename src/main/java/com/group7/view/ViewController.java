package com.group7.view;

import javax.swing.*;

public class ViewController extends JFrame{

    //panel main view is the parent panel. it holds all other panels.
    private JPanel panelMainView;

    //these holder panels contain nothing on their own and can be changed to hold whatever is needed.
    //Their names correspond with their positions on screen
    //Center panel can be used alone to fill the entire window
    private JPanel panelCLCenter;
    private JPanel panelCLLeft;
    private JPanel panelCLBottom;

    //Panel containers for different game states. Will be placed into holder panels as needed

    private JPanel playerEntryPanel;
    private PlayerEntry playerEntryObj;
    //private JPanel gameInfoPanel;
    //private GameInfo gameInfoObj;
    private JPanel handCardsPanel;

    private JPanel infoViewPanel;
    private InfoView infoViewObj;

    private JPanel cardViewerPanel;
    private CardViewer cardViewerObj;


    private HandCards handCardsObj;


    //window title defaults to welcome
    private String windowTitle = "Welcome!";

    //Panel and window sizing

    private int windowX = 1280;
    private int windowY = 720;
    int leftPanelWidth = (int) (windowX * .25);
    int leftPanelHeight = (int) (windowY * .4);

    public ViewController(){


        //create objects for each game panel
        playerEntryObj = new PlayerEntry(this);
        playerEntryPanel = playerEntryObj.getPanel();

        handCardsObj = new HandCards(this);
        handCardsPanel = handCardsObj.getPanel();

        infoViewObj = new InfoView(this);
        infoViewPanel = infoViewObj.getPanel();

        cardViewerObj = new CardViewer(this);
        cardViewerPanel = cardViewerObj.getPanel();

        //fill window with main view
        setContentPane(panelMainView);

        setTitle(windowTitle);
        setSize(windowX, windowY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Screen changers

    public void drawPlayerEntry(){
        changePanel(panelCLCenter, playerEntryPanel);
    }

    public void drawGameHome(){
        clearPanel(panelCLCenter);
        changePanel(panelCLLeft, infoViewPanel);
        changePanel(panelCLBottom, handCardsPanel);
    }
    void changePanel(JPanel controllerPanel, JPanel inPanel){

        controllerPanel.removeAll();
        controllerPanel.add(inPanel);
        controllerPanel.repaint();
        controllerPanel.revalidate();

        refresh();
    }

    private void clearPanel(JPanel controllerPanel){
        controllerPanel.removeAll();
        controllerPanel.repaint();
        controllerPanel.revalidate();
    }

    //refreshes values displayed for all screens

    public void refresh(){
        setTitle(windowTitle);
        infoViewObj.refresh();
        //gameInfoObj.refresh();
    }

    //set window title

    public void setWindowTitle(String inTitle){
        windowTitle = inTitle;
    }
}

