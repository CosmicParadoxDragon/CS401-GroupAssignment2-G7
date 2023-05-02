package com.group7.view;


import com.group7.model.Player;
import com.group7.model.cards.Card;
import com.group7.view.sfx.sfxController;
import com.group7.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewController extends JFrame{

    Controller controller;

    public ViewCardHandler cardHandler;

    Card cardInViewer;

    Player curActivePlayer;


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



    //game information on the upper left of screen. Also contains a card view on the bottom left
    public JPanel infoViewPanel;
    private InfoView infoViewObj;

    //Tabs for cards in hand
    private JPanel handCardsPanel;
    private HandCards handCardsObj;

    //the 4x4 tableau
    private TableauView tableauViewObj;
    private JPanel tableauViewPanel;

    //------------------------------------------------------------------------------------------------------------------
    //window set up, etc

    //window title defaults to welcome
    private String windowTitle = "Welcome!";

    //Panel and window sizing on game start. default is 720p. though it's mostly set up to be resizable,
    //some of the panel scaling is based on this default value and might get a bit strange if changed.
    //The window can still be resized after the game opens just fine though

    private int windowX = 1280;
    private int windowY = 720;
    int leftPanelWidth = (int) (windowX * .25);
    int leftPanelHeight = (int) (windowY * .4);

    //------------------------------------------------------------------------------------------------------------------

    public ViewController(Controller inControl){

        controller = inControl;
        cardHandler = new ViewCardHandler(this);
        curActivePlayer = controller.getGame().getActivePlayer();

        cardHandler.loadCards();


        //nice, large font for text boxes
        UIManager.put("TextArea.font", new Font("Arial", Font.BOLD, 16));

        //--------------------------------------------------------------------------------------------------------------
        //create objects for each game panel
        playerEntryObj = new PlayerEntry(this);
        playerEntryPanel = playerEntryObj.getPanel();

        handCardsObj = new HandCards(this, controller);
        handCardsPanel = handCardsObj.getPanel();

        infoViewObj = new InfoView(this);
        infoViewPanel = infoViewObj.getPanel();

        tableauViewObj = new TableauView(this, controller);
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
        //sfx.intro();
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

    public void setViewCard(String cardLocation, int inCardIndex){
        infoViewObj.setCurViewCard(cardLocation, inCardIndex);
        refresh();
    }

    //I mostly use this for debugging
    private void clearPanel(JPanel controllerPanel){
        controllerPanel.removeAll();
        controllerPanel.repaint();
        controllerPanel.revalidate();
    }

    //refreshes values displayed for all elements and arrays of cards
    public void refresh(){
        setTitle(windowTitle); //gets set to the players name after the entrance screen. It can be overridden below
        infoViewObj.refresh();

        curActivePlayer = controller.getGame().getActivePlayer();
    }


    //set window title
    public void setWindowTitle(String inTitle){
        windowTitle = inTitle;
    }

    public ArrayList<Card> getViewTableauCards(){
        return cardHandler.getViewCardsInTableau();
    }

    public ArrayList<Card> getViewCardsInHand(){
        return cardHandler.getViewCardsInHand();
    }

    public Player getViewActivePlayer(){
        return curActivePlayer;
    }
}

