package com.group7.view;

import javax.swing.*;
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
    int cardIndex;

    private boolean isMiniCard = false;

    private ViewController thisView;

    public CardViewer(ViewController inThisView, String inCardLocation, int inCardIndex){

        thisView = inThisView;
        cardLocation = inCardLocation;
        cardIndex = inCardIndex;

        switch (cardLocation){
            case "HAND":
                displayCard = thisView.getViewCardsInHand().get(cardIndex);
                break;

            case "TABLEAU":
                displayCard = thisView.getViewTableauCards().get(cardIndex);
                break;

            default:
                break;
        }

        if (thisView.isPromptActive()){

            btnPrompt1.setText(thisView.getCurPrompt().getCardButtonText());
            cbPrompt1.setText(thisView.getCurPrompt().getCardCheckboxText());

            if(thisView.getCurPrompt().isCardPrompting(cardLocation, cardIndex)){
                hasButton = thisView.getCurPrompt().hasButton(cardLocation,cardIndex);
                hasCheckbox = thisView.getCurPrompt().hasCheckbox(cardLocation,cardIndex);

            }
        }



        setCardView();

        btnViewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisView.sfx.cardFlip();
                thisView.setViewCard(cardLocation, cardIndex);
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
    }

    private void setCardView(){

        if(isEmpty()) {
            setEmptySpace();
        }
        else{
            lblCardTitle.setText(displayCard.getM_name());
            taCardAbility.setText(displayCard.getM_text());



            lblCardTitle.enable(true);
            taCardAbility.setVisible(true);
            lblVictoryPoints.setVisible(true);
            lblVictoryPointsVal.setVisible(true);
            btnViewCard.setVisible(isMiniCard);

        }
        //Need a way to get card color

        //lblVictoryPointsVal.setText();
    }


    void setNewCard(Card inDisplayCard){
        displayCard = inDisplayCard;
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
