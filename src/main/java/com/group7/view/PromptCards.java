package com.group7.view;

public class PromptCards {

    int cardX;
    int cardY;
    boolean checkBox;
    boolean cardButton;

    public PromptCards(int inCardX, int inCardY, boolean inCheckBox, boolean inCardButton){
        cardX = inCardX;
        cardY = inCardY;
        checkBox = inCheckBox;
        cardButton = inCardButton;
    }

    public PromptCards(int inCardX, boolean inCheckBox, boolean inCardButton){
        cardX = inCardX;
        cardY = -1;
        checkBox = inCheckBox;
        cardButton = inCardButton;
    }

    public int getCardX() {
        return cardX;
    }

    public int getCardY() {
        return cardY;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public boolean isCardButton() {
        return cardButton;
    }


}
