package com.group7.model.board;

import com.group7.model.cards.Card;

import java.util.ArrayList;

public class Tableau {
    /**
     * 4x4 representation of the tableau
     */
    private ArrayList<ArrayList<Card>> m_board;

    public Card getCard(int row, int column){
        return m_board.get(row).get(column);
    }
    public ArrayList<ArrayList<Card>> getBoard()
    {
        return m_board;
    }
    public Tableau()
    {
        m_board = new ArrayList<ArrayList<Card>>();
        for(int x = 0; x < 4; x++)
        {
            m_board.add(new ArrayList<Card>());
            for (int y = 0; y < 4; y++)
            {
                m_board.get(x).add(new Card(Card.NULL_CARD));
            }
        }
    }

    public void setCard(int row, int column, Card insertCard){
        if(getCard(row, column) != null) {
            ; /** do nothing, there's already a card here*/
        } else {
            m_board.get(row).add(insertCard);
            System.out.println("card upkeep not implemented yet!");
            /** upkeep for card insertion here*/

        }
    }

    public Boolean isBoardEmpty() {
        for (int x = 0; x < 4; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                if (m_board.get(x).get(y).getM_name().equals(Card.NULL_CARD)) { return false; }
            }
        }
        return true;
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
        if (m_board.size() == 4)
            for (int x = 0; x < 4; x++)
            {
                if (m_board.get(x).size() != 4) { return false; }
            }
        return true;
    }
}
