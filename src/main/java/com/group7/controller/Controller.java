
package com.group7.controller;

import com.formdev.flatlaf.FlatDarkLaf;
import com.group7.model.Game;
import com.group7.model.cards.Card;
import com.group7.view.ViewController;
import com.group7.view.*;
import com.group7.model.cards.Card;

import javax.swing.text.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


public class Controller {
    Game m_game;
    ArrayList<PromptCards> prompts = new ArrayList<PromptCards>();
    ArrayList<PromptCards> promptOut = new ArrayList<PromptCards>();
    CountDownLatch waiter;

    ViewController m_gui;
    public Controller(String threaded) {
        FlatDarkLaf.setup();
    }
    public Controller() throws IOException {
        m_game = new Game(this, 1);
        m_game.GameStart();

        FlatDarkLaf.setup(); //initialize gui theme
        m_gui = new ViewController(this);

        m_gui.drawPlayerEntry();

        setWait(1); //view will decrement this number by one on submit button presses. Waiting for one button press
        startWaiting(); //waiting for button press from view

        m_gui.drawGameHome();

        m_gui.setStatus("Welcome!\n" +
                "This intro should show you how to use the viewer and prompter. " +
                "Here I've added a button to the first card in the players hand." +
                "Click on the card, then press Select.");
        m_gui.prompt().setCardButtonText("Select");

        prompts.add(new PromptCards(0,false,true));
        m_gui.prompt().addPromptCardList(prompts);
        m_gui.promptActivate();

        setWait(1);
        startWaiting();

        promptOut = m_gui.prompt().getSelections();
        m_gui.promptDeactivate();
        m_gui.prompt().reset();

        String promptTutorial = "";
        m_gui.setStatus("You selected the card at "
                + promptTutorialOutput(promptOut, promptTutorial)
                + "Note that a y value of -1 indicates that the card is in the player's hand.\nIsn't that slick?");
        m_gui.prompt().setLeftPanelButton(true);
        m_gui.prompt().setLeftPanelButtonText("It Sure Is!");
        m_gui.promptActivate();

        setWait(1);
        startWaiting();

        m_gui.promptDeactivate();
        m_gui.prompt().reset();

        m_game.getActivePlayer().getPlayerTableau().setCard(0,0,m_game.getFuanaDeck().getDeckList().get(0));
        m_game.getActivePlayer().getPlayerTableau().setCard(1,3,m_game.getFuanaDeck().getDeckList().get(1));
        m_game.getActivePlayer().getPlayerTableau().setCard(3,2,m_game.getFuanaDeck().getDeckList().get(0));

        m_gui.hardRefresh(); //reloads cards from backend. Also resets list of prompted cards

        m_gui.setStatus("You can even have the user select multiple cards by adding checkboxes. " +
                "Two of the cards in the tableau and one card in your hand are selectable. Select them, then press submit!");
        m_gui.prompt().setLeftPanelButton(true);
        m_gui.prompt().setLeftPanelButtonText("Submit");
        m_gui.prompt().setCheckboxText("Select");

        prompts.clear();
        promptOut.clear();
        prompts.add(new PromptCards(1,3, true, false));
        prompts.add(new PromptCards(3,2,true, false));
        prompts.add(new PromptCards(0,true,false));

        int numSelectedCards;
        while(true){
            numSelectedCards = 0;
            m_gui.promptDeactivate();
            m_gui.prompt().addPromptCardList(prompts);
            m_gui.promptActivate();

            setWait(1);
            startWaiting();

            promptOut = m_gui.prompt().getSelections();

            for (int i = 0; i < promptOut.size(); i++){
                if(promptOut.get(i).isCheckBox()){
                    numSelectedCards = numSelectedCards + 1;
                }
            }
            if (numSelectedCards == 3){
                break;
            }
            else {
                m_gui.setStatus("You selected " + numSelectedCards +". Please select three cards instead.");
            }
        }

        promptTutorial = "";
        m_gui.setStatus("You selected the card(s)\n"
                + promptTutorialOutput(prompts, promptTutorial)
                + "How awesome is that?");

        m_gui.prompt().reset();
        prompts.clear();
        m_gui.promptDeactivate();
    }

    public String promptTutorialOutput(ArrayList<PromptCards> inPrompts, String testSelection){

        for(int i = 0; i < inPrompts.size(); i++) {
            PromptCards curCard = inPrompts.get(i);
                    testSelection = testSelection
                    + curCard.getCardX()
                    + ", "
                    + curCard.getCardY()
                    + " using ";
            if (curCard.isCheckBox()) {
                testSelection = testSelection + "the checkbox!\n";
            } else if (curCard.isCardButton()) {
                testSelection = testSelection + "the card button!\n";
            }
        }
        return testSelection;
    }

    public void setGame (Game gameObj) { m_game = gameObj; }
    public void setGui (ViewController viewObj) { m_gui = viewObj; }
    public Game getGame() {
        return m_game;
    }
    public ViewController getGui() { return m_gui; }

    public String getActionChoice()
    {
        String action = "planting";
        // Assumeing planting for testing and progression purposes
        // m_tui.promptForActionChoice();

        return action;
    }
    public Card getCardChoice()
    {
        Card someCard;
        // This is the ideal production use case for this function, being handed a card object that 
        // the user selected from the hand based in the UI.
        // card = m_tui.getCardChoice(); // Need some way to limit choice to a specific vector of cards 
        // System.out.print("Enter a card number to discard: ");

        // this is a unplayable line that should not be included in a final release, but serves 
        // for testing purposes, as a way to discard in auto/test mode builds

        someCard = getGame().getActivePlayer().getHand().get(0);


        return someCard;


    }

    public CountDownLatch getWaiter() {
        return waiter;
    }

    //sets number of countdowns to wait for
    void setWait(int inWait) {
        this.waiter = new CountDownLatch(inWait);
    }

    void startWaiting(){
        try {
            waiter.await(); //when waiter gets to zero, execution in controller advances past this block
        }catch (InterruptedException e){
        }
    }
}