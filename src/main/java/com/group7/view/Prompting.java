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
    ArrayList<PromptCards> promptSelections = new ArrayList<PromptCards>();

    ViewController thisView;

    Prompting(ViewController inThisView){
        thisView = inThisView;
    }

//    public void initializePrompt(String inStatusText, String inCardButtonText, String inCheckboxText, String inInfoButtonText, boolean drawInfoButton){
//        promptSelections.clear();
//        statusText = inStatusText;
//        cardButtonText = inCardButtonText;
//        infoButtonText = inInfoButtonText;
//        checkboxText = inCheckboxText;
//        infoButton = drawInfoButton;
//    }

    public void reset(){
        promptSelections.clear();
        statusText = "";
        cardButtonText = "";
        infoButtonText = "";
        checkboxText = "";
        infoButton = false;
    }

    public void resetPromptSelections(){
        promptSelections.clear();
    }

    public void addPromptCardList(ArrayList<PromptCards> inPrompts){
        PromptCards curPrompt;

        for (int i = 0; i < inPrompts.size(); i++){
            curPrompt = inPrompts.get(i);

            if(inPrompts.get(i).cardY == -1){
                addCardPrompt(curPrompt.cardX, curPrompt.cardButton, curPrompt.checkBox);
                promptSelections.add(new PromptCards(curPrompt.cardX, false,false));
            } else{
                addCardPrompt(curPrompt.cardX, curPrompt.cardY, curPrompt.cardButton, curPrompt.checkBox);
                promptSelections.add(new PromptCards(curPrompt.cardX, curPrompt.cardY, false,false));
            }
        }
    }

    public ArrayList<PromptCards> getSelections(){
        return new ArrayList<>(promptSelections);
    }

    //add prompt for tableau
    void addCardPrompt(int inCardX, int inCardY, boolean inCardButton, boolean inCardCheckbox){
        int tableauIndex;

        tableauIndex = thisView.getViewCards().getCardIndex(inCardX,inCardY);
        thisView.getViewCards().setTableauButton(tableauIndex, inCardButton);
        thisView.getViewCards().setTableauCheckbox(tableauIndex,inCardCheckbox);
    }

    void addCardPrompt(int inCardX, boolean inCardButton, boolean inCardCheckbox){
        //handPromptLocations.add(new PromptLoc(inCardX,inCardButton,inCardCheckbox));
        thisView.getViewCards().setHandButton(inCardX, inCardButton);
        thisView.getViewCards().setHandCheckbox(inCardX,inCardCheckbox);
    }

    void addViewController(ViewController inThisView){
        thisView = inThisView;
    }

    String getCardButtonText() {
        return cardButtonText;
    }

    String getCardCheckboxText() {
        return checkboxText;
    }

    String getStatusText(){
        return statusText;
    }

    public boolean isInfoButton() {
        return infoButton;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setCardButtonText(String cardButtonText) {
        this.cardButtonText = cardButtonText;
    }

    public void setLeftPanelButtonText(String infoButtonText) {
        this.infoButtonText = infoButtonText;
    }

    public void setCheckboxText(String checkboxText) {
        this.checkboxText = checkboxText;
    }

    public void setLeftPanelButton(boolean infoButton) {
        this.infoButton = infoButton;
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



