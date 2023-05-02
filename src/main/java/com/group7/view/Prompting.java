package com.group7.view;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Prompting {

    ArrayList<String> parsedParameters;

    ArrayList<PromptLoc> tableauPromptLocations = new ArrayList<PromptLoc>();
    ArrayList<PromptLoc> handPromptLocations = new ArrayList<PromptLoc>();

    String statusText;
    String cardButtonText;
    String infoButtonText;
    String checkboxText;

    ViewController thisView;

    String promptTestString = "";

    /*
    parameter string should be laid out like this:

    Your Status Text; Target Card Type; Button 1 text (false if no button)

     */
    public Prompting(String inStatusText, String inCardButtonText, String inInfoButtonText, String inCheckboxText){

        //thisView = inThisView;
        statusText = inStatusText;
        cardButtonText = inCardButtonText;
        infoButtonText = inInfoButtonText;
        checkboxText = inCheckboxText;


        //promptTest();

    }

    //add prompt for tableau
    public void addCardPrompt(int inCardX, int inCardY, boolean inCardButton, boolean inCardCheckbox){
        tableauPromptLocations.add(new PromptLoc(inCardX,inCardY,inCardButton,inCardCheckbox));
    }

    public void addCardPrompt(int inCardX, boolean inCardButton, boolean inCardCheckbox){
        handPromptLocations.add(new PromptLoc(inCardX,inCardButton,inCardCheckbox));
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

    }


    /*
    private ArrayList<String> getParsedParameters(String inParameters){
        String[] paraSplit = inParameters.split("; ");

        ArrayList<String> arParaSplit = new ArrayList<String>(Arrays.asList(paraSplit));

        return arParaSplit;
    }

     */


    /*
    private void promptTest(){

        String button = "";

        promptTestString = promptTestString + "Test Status: " + statusText + "\n";
        promptTestString = promptTestString + "Test Target: " + targetCards + "\n";

        if (btn1 == false){
            button = "Button 1 is inactive";
        }
        else {
            button = "Button 1 is active with text " + btn1Text;
        }

        promptTestString = promptTestString + button + "\n";

        thisView.setInfoStatus(promptTestString);
    }

    private class promptLoc{
        int cardX;
        int cardY;

        promptLoc(int cardX, String inCardLocation){

        }
    }

     */
}

