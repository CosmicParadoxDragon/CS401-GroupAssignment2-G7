package com.group7.view;

import com.group7.model.Player;
import com.group7.model.cards.Card;

import java.util.ArrayList;

public class ViewCardHandler {

    private ViewController thisView;
    private Player curActivePlayer;

    ArrayList<CardLoc> viewCardsInHand = new ArrayList<CardLoc>();
    ArrayList<CardLoc> viewCardsInTableau = new ArrayList<CardLoc>();



    ArrayList<Card> viewCardsIslCli = new ArrayList<Card>();

    public ViewCardHandler(ViewController inThisView){
        thisView = inThisView;


    }
    public void loadCards(){

        viewCardsInTableau.clear();
        viewCardsInHand.clear();
        viewCardsIslCli.clear();


        //gets cards from player tableau and dumps into one-dimensional array list
        //could be done in a way to preserve the two-dimensional array, but I want
        //compatibility with the hand card array

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    viewCardsInTableau.add(new CardLoc(j, i, thisView.getViewActivePlayer().getPlayerTableau().getCard(j, i)));
                }
            }

            for (int i = 0; i < thisView.getViewActivePlayer().getHand().size(); i++){
                viewCardsInHand.add(new CardLoc(i, thisView.getViewActivePlayer().getHand().get(i)));
            }

            viewCardsIslCli.add(thisView.getViewActivePlayer().getIslandCard());
            viewCardsIslCli.add(thisView.getViewActivePlayer().getClimateCard());
    }

    public Card getViewCardInHand(int inCardIndex){
        if (inCardIndex > viewCardsInHand.size() || viewCardsInHand.size() == 0){
            return null;
        }
        else {
            return viewCardsInHand.get(inCardIndex).getCard();
        }
    }

    //for getting card based on 1D index
    public Card getViewCardInTableau(int inCardIndex){
        return viewCardsInTableau.get(inCardIndex).getCard();
    }

    public Card getIslandClimate(int inCardIndex){
        return viewCardsIslCli.get(inCardIndex);
    }

    //for getting card based on 2D location
    public Card getViewCardInTableau(int inCardX, int inCardY){
        for (int i = 0; i < viewCardsInTableau.size(); i++){
            if (viewCardsInTableau.get(i).isCard(inCardX, inCardY)){
                return viewCardsInTableau.get(i).getCard();
            }
        }
        return null;
    }

    public Card getViewCardIslCli(int inCardIndex) {
        return viewCardsIslCli.get(inCardIndex);
    }

    int getCardIndex(int inCardX, int inCardY){
        for (int i = 0; i < viewCardsInTableau.size(); i++){
            if (viewCardsInTableau.get(i).isCard(inCardX, inCardY)){
                return i;
            }
        }
        return 0;
    }

    public int getViewTableauSize(){
        return viewCardsInTableau.size();
    }

    public int getViewHandSize(){
        return viewCardsInHand.size();
    }

    //------------------------------------------------------------------------------------------------------------------
    //setters for prompt element visibility and state, getters for state
    //a bit inefficient
    void setHandButton(int inCardIndex, boolean inButton){
        viewCardsInHand.get(inCardIndex).btn = inButton;
    }

    boolean hasHandButton(int inCardIndex){
        return viewCardsInHand.get(inCardIndex).btn;
    }

    void setHandButtonState(int inCardIndex, boolean inButtonState){
        viewCardsInHand.get(inCardIndex).btnState = inButtonState;
        int promptIndex;
        promptIndex = promptSelection(inCardIndex);
        if (promptSelection(inCardIndex) != -1){
            thisView.getCurPrompt().promptSelections.get(promptIndex).cardButton = true;
        }
    }

    boolean getHandButtonState(int inCardIndex){
        return viewCardsInHand.get(inCardIndex).btnState;
    }

    void setHandCheckbox(int inCardIndex,boolean inCheckbox){
        viewCardsInHand.get(inCardIndex).chk = inCheckbox;
    }

    boolean hasHandCheckbox(int inCardIndex){
        return viewCardsInHand.get(inCardIndex).chk;
    }

    void setHandCheckboxState(int inCardIndex, boolean inCheckboxState){
        viewCardsInHand.get(inCardIndex).chkState = inCheckboxState;

        int promptIndex;
        promptIndex = promptSelection(inCardIndex);
        if (promptSelection(inCardIndex) != -1){
            thisView.getCurPrompt().promptSelections.get(promptIndex).checkBox = inCheckboxState;
        }
    }

    boolean getHandCheckboxState(int inCardIndex){
        return viewCardsInHand.get(inCardIndex).chkState;
    }

    //--------------------------------------------------------------------------------------------------------------

    void setTableauButton(int inCardIndex, boolean inButton){
        viewCardsInTableau.get(inCardIndex).btn = inButton;
    }

    boolean hasTableauButton(int inCardIndex){
        return viewCardsInTableau.get(inCardIndex).btn;
    }

    void setTableauButtonState(int inCardIndex, boolean inButtonState){
        viewCardsInTableau.get(inCardIndex).btnState = inButtonState;
    }

    boolean getTableauButtonState(int inCardIndex){
        return viewCardsInTableau.get(inCardIndex).btnState;
    }

    void setTableauCheckbox(int inCardIndex,boolean inCheckbox){
        viewCardsInTableau.get(inCardIndex).chk = inCheckbox;
    }

    boolean hasTableauCheckbox(int inCardIndex){
        return viewCardsInTableau.get(inCardIndex).chk;
    }

    void setTableauCheckboxState(int inCardIndex, boolean inCheckboxState){
        viewCardsInTableau.get(inCardIndex).chkState = inCheckboxState;

        int promptIndex;
        int cardX = viewCardsInTableau.get(inCardIndex).cardX;
        int cardY = viewCardsInTableau.get(inCardIndex).cardY;


        promptIndex = promptSelection(cardX, cardY);
        if (promptIndex != -1){
            thisView.getCurPrompt().promptSelections.get(promptIndex).checkBox = inCheckboxState;
        }
    }

    boolean getTableauCheckboxState(int inCardIndex){
        return viewCardsInTableau.get(inCardIndex).chkState;
    }

    int promptSelection(int inCardX){
        ArrayList<PromptCards> prompts;

        if (thisView.isPromptActive() && !thisView.getCurPrompt().promptSelections.isEmpty()){
            prompts = thisView.getCurPrompt().promptSelections;

            for (int i = 0; i < prompts.size(); i++){
                if (viewCardsInHand.get(inCardX).cardX == prompts.get(i).cardX && prompts.get(i).cardY == -1){
                    return i;
                }
            }
        }

        return -1;
    }

    int promptSelection(int inCardX, int inCardY){
        ArrayList<PromptCards> prompts;

        if (thisView.isPromptActive() && !thisView.getCurPrompt().promptSelections.isEmpty()){
            prompts = thisView.getCurPrompt().promptSelections;

            for (int i = 0; i < prompts.size(); i++){
                if (inCardX == prompts.get(i).cardX && prompts.get(i).cardY == inCardY){
                    return i;
                }
            }
        }

        return -1;
    }

//    boolean promptSelection(int inCardX, int inCardY){
//        ArrayList<PromptCards> prompts;
//
//        if (!thisView.getCurPrompt().promptSelections.isEmpty()){
//            prompts = thisView.getCurPrompt().promptSelections;
//            for (int i = 0; i < prompts.size(); i++){
//                if(prompts.get(i).cardX == inCardX && prompts.get(i).cardY == inCardY){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    class CardLoc {

        Card card;
        int cardX;
        int cardY;

        //--------------------------------------------------------------------------------------------------------------
        //prompt element visibility and state
        boolean btn = false;
        boolean btnState = false;
        boolean chk = false;
        boolean chkState = false;


        CardLoc(int inCardX, int inCardY, Card inCard){
            card = inCard;
            cardX = inCardX;
            cardY = inCardY;
        }

        CardLoc(int inCardX, Card inCard){
            card = inCard;
            cardX = inCardX;
            cardY = -1;
        }

        boolean hasButton(){
            return btn;
        }

        void setButton(boolean inButton){
            btn = inButton;
        }

        void setButtonState(boolean inButtonState){
            btnState = inButtonState;
        }

        boolean hasCheckbox(){
            return chk;
        }

        void setCheckbox(boolean inCheckbox){
            chk = inCheckbox;
        }

        void setCheckboxState(boolean inCheckboxState){
            chk = inCheckboxState;
        }

        Card getCard(){
            return card;
        }

        boolean isCard(int inCardX, int inCardY){
            if (cardX == inCardX && cardY == inCardY){
                return true;
            }
            else return false;
        }

        boolean checkCard(int inCardX){
            if (cardX == inCardX && cardY == -1){
                return true;
            }
            else return false;
        }
    }
}

