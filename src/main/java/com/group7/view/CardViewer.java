package com.group7.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.group7.model.cards.Card;

public class CardViewer {

    //panel elements
    private JPanel panelCardView;
    private JTextArea taCardAbility;
    private JLabel lblVictoryPoints;
    private JLabel lblVictoryPointsVal;
    private JButton btnViewCard;
    private JLabel lblCardTitle;
    private JButton btnPrompt1;
    private JCheckBox cbPrompt1;

    private Card displayCard;

    String cardLocation;

    boolean hasButton = false;
    boolean hasCheckbox = false;

    boolean isChecked = false;
    int cardIndex;

    private boolean isMiniCard = false;

    private ViewController thisView;

    public CardViewer(ViewController inThisView, String inCardLocation, int inCardIndex){

        thisView = inThisView;

        setNewCard(inCardLocation, inCardIndex);

        setCardView();

        btnViewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.cardFlip();
                thisView.setViewCard(cardLocation, cardIndex);
            }
        });
        cbPrompt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = cbPrompt1.isSelected();

                if(selected)thisView.sfx.check();
                else thisView.sfx.uncheck();


                if (cardLocation == "HAND"){
                    thisView.getViewCards().setHandCheckboxState(cardIndex, selected);

                } else if (cardLocation == "TABLEAU") {
                    thisView.getViewCards().setTableauCheckboxState(cardIndex, selected);
                }

                //allows tableau to indicate which cards have been selected via checkbox
                thisView.softRefresh();

            }
        });
        btnPrompt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.ping();

                if (cardLocation == "HAND"){
                    thisView.getViewCards().setHandButtonState(cardIndex, true);

                } else if (cardLocation == "TABLEAU") {
                    //thisView.getViewCards().setTableauCheckboxState(cardIndex, selected);
                }

                thisView.controller.getWaiter().countDown();
            }
        });
    }


    public boolean isEmpty(){
         if ((displayCard == null) || (displayCard.getM_name() == Card.NULL_CARD)){
             return true;
         }
         else{
             return false;
         }
    }

    private void setEmptySpace(){
        lblCardTitle.setText("Card Space");
        lblCardTitle.enable(false); //enable = false grays out text

        //make empty sections not visible
        taCardAbility.setVisible(false);
        lblVictoryPoints.setVisible(false);
        lblVictoryPointsVal.setVisible(false);
        btnViewCard.setVisible(false);
        btnPrompt1.setVisible(false);
        cbPrompt1.setVisible(false);
    }

    private void setCardView(){

        if(isEmpty()) {
            setEmptySpace();
        }
        else{
            lblCardTitle.setText(displayCard.getM_name());
            taCardAbility.setText(displayCard.getM_text());

            //debug
//            String debugText;
//
//            debugText = "Card Location: " + cardLocation + "\n"
//            + "Card Index: " + cardIndex + "\n"
//            + "Viewer Is Checked: " + isChecked + "\n"
//            ;

//            taCardAbility.setText(debugText);



            lblCardTitle.enable(true);
            taCardAbility.setVisible(true);
            lblVictoryPoints.setVisible(true);
            lblVictoryPointsVal.setVisible(true);

            if(isMiniCard){
                btnViewCard.setVisible(isMiniCard);
                btnPrompt1.setVisible(false);
                cbPrompt1.setVisible(false);
                taCardAbility.setVisible(false);
            }
            else {
                btnViewCard.setVisible(false);
                btnPrompt1.setVisible(hasButton);
                cbPrompt1.setVisible(hasCheckbox);
                cbPrompt1.setSelected(isChecked);
            }

            if(isChecked){
                panelCardView.setBackground(Color.gray);
            }

        }
        //Need a way to get card color

        //lblVictoryPointsVal.setText();
    }


    void setNewCard(String inCardLocation, int inCardIndex){

        cardLocation = inCardLocation;
        cardIndex = inCardIndex;

        hasButton = false;
        hasCheckbox = false;
        isChecked = false;

        switch (cardLocation){
            case "HAND":
                if (thisView.isPromptActive()) {
                    btnPrompt1.setText(thisView.getCurPrompt().getCardButtonText());
                    cbPrompt1.setText(thisView.getCurPrompt().getCardCheckboxText());
                    hasButton = thisView.getViewCards().hasHandButton(inCardIndex);
                    hasCheckbox = thisView.getViewCards().hasHandCheckbox(inCardIndex);
                    isChecked = thisView.getViewCards().getHandCheckboxState(inCardIndex);
                }
                //displayCard = thisView.getViewCardsInHand().get(cardIndex);
                displayCard = thisView.getViewCards().getViewCardInHand(inCardIndex);
                break;

            case "TABLEAU":
                if (thisView.isPromptActive()) {
                    btnPrompt1.setText(thisView.getCurPrompt().getCardButtonText());
                    cbPrompt1.setText(thisView.getCurPrompt().getCardCheckboxText());
                    hasButton = thisView.getViewCards().hasTableauButton(inCardIndex);
                    hasCheckbox = thisView.getViewCards().hasTableauCheckbox(inCardIndex);
                    isChecked = thisView.getViewCards().getTableauCheckboxState(inCardIndex);
                }
                //displayCard = thisView.getViewTableauCards().get(cardIndex);
                displayCard = thisView.getViewCards().getViewCardInTableau(inCardIndex);
                break;

            case "ISLANDCLIMATE":
                displayCard = thisView.getViewCards().getViewCardIslCli(inCardIndex);
                break;

            default:
                break;
        }

        setCardView();

    }



    //changes card to small tile. removes ability text box and adds a view card button
    void setMiniCard(){
        isMiniCard = true;
        setCardView();
    }

    JPanel getPanel(){
        return panelCardView;
    }
}
