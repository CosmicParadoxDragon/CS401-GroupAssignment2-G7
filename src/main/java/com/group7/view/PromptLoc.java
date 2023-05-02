package com.group7.view;

public class PromptLoc {

    int cardX;
    int cardY;

    boolean btn = false;
    boolean chk = false;

    PromptLoc(int inCardX, int inCardY, boolean inBtn, boolean inChk){
        cardX = inCardX;
        cardY = inCardY;
        btn = inBtn;
        chk = inChk;
    }

    PromptLoc(int inCardX, boolean inBtn, boolean inChk){
        cardX = inCardX;
        cardY = -1;
        btn = inBtn;
        chk = inChk;
    }

    /*
    boolean hasButton(){
        return btn;
    }

    boolean hasCheckbox(){
        return chk;
    }

     */
}
