package com.group7.model.Board;

import com.group7.model.Cards.Card;

public class Tableau {
    /**
     * 4x4 representation of the tableau
     */
    private Card[][] Board = new Card[4][4];

    public Card getCard(int row, int column){
        return Board[row][column];
    }


    public void setCard(int row, int column, Card insertCard){
        if(getCard(row, column) != null) {
            ; /** do nothing, there's already a card here*/
        } else {
            Board[row][column] = insertCard;
            System.out.println("card upkeep not implemented yet!");
            /** upkeep for card insertion here*/

        }
    }

    public void getPoints(){
        System.out.println("not implemented yet!");
    }

    public void getOpenGrowth(){
        System.out.println("not implemented yet!");
    }

    public void getFilledGrowth(){
        System.out.println("not implemented yet!");
    }

    public void getOpenCubes(){
        System.out.println("not implemented yet!");
    }

    public void getFilledCubes(){
        System.out.println("not implemented yet!");
    }

    public Boolean isBoardFilled(){
        for (Card[] row : Board){
            for (Card column : row){
                if(column == null){
                    return false;
                }
            }
        }
        return true;
    }
}
