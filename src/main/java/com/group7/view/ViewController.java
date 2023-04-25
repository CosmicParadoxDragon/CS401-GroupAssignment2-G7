package com.group7.view;

import com.group7.view.sfx.sfxController;
import com.group7.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class ViewController extends JFrame{

    Controller controller;

    public sfxController sfx = new sfxController();
    //panel main view is the parent panel. it holds all other panels.
    private JPanel panelMainView;

    //these holder panels contain nothing on their own and can be changed to hold whatever is needed.
    //Their names correspond with their positions on screen
    //Center panel can be used alone to fill the entire window
    private JPanel panelCLCenter;
    private JPanel panelCLLeft;
    private JPanel panelCLBottom;

    //------------------------------------------------------------------------------------------------------------------
    //Panel containers for different game elements & states. Will be placed into holder panels as needed

    //Player info entry screen
    private JPanel playerEntryPanel;
    private PlayerEntry playerEntryObj;

    //Tabs for cards in hand
    private JPanel handCardsPanel;
    private HandCards handCardsObj;

    //game information on the upper left of screen. Also contains a card view on the bottom left
    private JPanel infoViewPanel;
    private InfoView infoViewObj;

    //Card viewer, both the small tiles in the tableau and the large card viewer on the bottom left
    private JPanel cardViewerPanel;
    private CardViewer cardViewerObj;

    //the 4x4 tableau
    private TableauView tableauViewObj;
    private JPanel tableauViewPanel;

    //------------------------------------------------------------------------------------------------------------------
    //window set up, etc

    //window title defaults to welcome
    private String windowTitle = "Welcome!";

    //Panel and window sizing. default is 720p, though it's mostly set up to be resizable

    private int windowX = 1280;
    private int windowY = 720;
    int leftPanelWidth = (int) (windowX * .25);
    int leftPanelHeight = (int) (windowY * .4);

    //------------------------------------------------------------------------------------------------------------------

    public ViewController(Controller inControl){

        controller = inControl;


        //nice, large font for text boxes
        UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 16));

        //--------------------------------------------------------------------------------------------------------------
        //create objects for each game panel
        playerEntryObj = new PlayerEntry(this);
        playerEntryPanel = playerEntryObj.getPanel();

        handCardsObj = new HandCards(this);
        handCardsPanel = handCardsObj.getPanel();

        infoViewObj = new InfoView(this);
        infoViewPanel = infoViewObj.getPanel();

        cardViewerObj = new CardViewer(this);
        cardViewerPanel = cardViewerObj.getPanel();

        tableauViewObj = new TableauView(this);
        tableauViewPanel = tableauViewObj.getPanel();

        //--------------------------------------------------------------------------------------------------------------
        //initialize game window

        //panelMainView contains the sub panels that hold all the other elements
        setContentPane(panelMainView);

        setTitle(windowTitle);
        setSize(windowX, windowY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }

    //------------------------------------------------------------------------------------------------------------------
    //Screen changers

    //player info entry screen
    public void drawPlayerEntry(){

        changePanel(panelCLCenter, playerEntryPanel);
    }

    //main game window with tableau, etc
    public void drawGameHome(){

        changePanel(panelCLCenter, tableauViewPanel);
        changePanel(panelCLLeft, infoViewPanel);
        changePanel(panelCLBottom, handCardsPanel);
    }

    //method to place game element panels inside screen panels
    void changePanel(JPanel controllerPanel, JPanel inPanel){

        controllerPanel.removeAll();
        controllerPanel.add(inPanel);
        controllerPanel.repaint();
        controllerPanel.revalidate();

        refresh();
    }

    //I mostly use this for debugging
    private void clearPanel(JPanel controllerPanel){
        controllerPanel.removeAll();
        controllerPanel.repaint();
        controllerPanel.revalidate();
    }

    //refreshes values displayed for all elements
    public void refresh(){
        setTitle(windowTitle); //gets set to the players name after the entrance screen. It can be overridden below
        infoViewObj.refresh();
    }

    //set window title
    public void setWindowTitle(String inTitle){
        windowTitle = inTitle;
    }
}

