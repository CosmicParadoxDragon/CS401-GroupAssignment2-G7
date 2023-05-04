package com.group7.view;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Prompting {

    String statusText;
    String cardButtonText;
    String infoButtonText;
    String checkboxText;

    boolean infoButton = false;

    ViewController thisView;

    Prompting(ViewController inThisView){
        thisView = inThisView;
    }

    public void initializePrompt(String inStatusText, String inCardButtonText, String inCheckboxText, String inInfoButtonText, boolean drawInfoButton){
        statusText = inStatusText;
        cardButtonText = inCardButtonText;
        infoButtonText = inInfoButtonText;
        checkboxText = inCheckboxText;
        infoButton = drawInfoButton;
    }



    //add prompt for tableau
    public void addCardPrompt(int inCardX, int inCardY, boolean inCardButton, boolean inCardCheckbox){
        int tableauIndex;

        tableauIndex = thisView.getViewCards().getCardIndex(inCardX,inCardY);
        thisView.getViewCards().setTableauButton(tableauIndex, inCardButton);
        thisView.getViewCards().setTableauCheckbox(tableauIndex,inCardCheckbox);
    }

    public void addCardPrompt(int inCardX, boolean inCardButton, boolean inCardCheckbox){
        //handPromptLocations.add(new PromptLoc(inCardX,inCardButton,inCardCheckbox));
        thisView.getViewCards().setHandButton(inCardX, inCardButton);
        thisView.getViewCards().setHandCheckbox(inCardX,inCardCheckbox);
    }

    public void addViewController(ViewController inThisView){
        thisView = inThisView;
    }

    public String getCardButtonText() {
        return cardButtonText;
    }

    public String getCardCheckboxText() {
        return checkboxText;
    }

    public String getStatusText(){
        return statusText;
    }

    public boolean isCardPrompting(String cardLocation, int cardIndex) {

        return false;
    }

    int getPromptIndex(String cardLocation, int cardIndex){
        switch (cardLocation){
            case "HAND":

                break;

            case "TABLEAU":

                break;

            default:
                break;
        }
        return 0;
    }
}



