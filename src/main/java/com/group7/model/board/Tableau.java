package com.group7.model.board;

import com.group7.model.cards.Card;

import java.util.ArrayList;

public class Tableau {
    /**
     * 4x4 representation of the tableau
     */
    private ArrayList<ArrayList<Card>> m_board;
    private boolean emptyBoard = true;
    private boolean[][] boardState= {
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true}};;
    public Card getCard(int row, int column){
        return m_board.get(row).get(column);
    }
    final String VALID_PLANTING = "VALID PLANTING";
    public ArrayList<ArrayList<Card>> getBoard()
    {
        return m_board;
    }
    public Tableau() {
        m_board = new ArrayList<>();
        for(int x = 0; x < 4; x++) {
            m_board.add(new ArrayList<>());
            for (int y = 0; y < 4; y++) {
                m_board.get(x).add(new Card(Card.NULL_CARD));
            }
        }
    }

    public Tableau(Card globalSet) {
        m_board = new ArrayList<>();
        for(int x = 0; x < 4; x++) {
            m_board.add(new ArrayList<>());
            for (int y = 0; y < 4; y++) {
                m_board.get(x).add(globalSet);
            }
        }
    }
    public void makeValidPlantLocations() {
        boardState = getValidPlantSpaces();
        for (int x = 0; x < 4; x++) {
            for (int  y = 0; y < 4; y++) {
                if ( boardState[x][y] ) {
                    setCard(x,y,new Card(VALID_PLANTING));
                }
                else {
                    setCard(x,y,new Card(Card.NULL_CARD));
                }
            }
        }
    }
    public void setFlagedTo(boolean[][] flags, Card toSet) {
        for (int x =0; x < flags.length; x++) {
            for (int y =0; y < flags[x].length; y++) {
                setCard(x,y, toSet);
            }
        }
    }

    public void setCard(int row, int column, Card insertCard){
        // if(!getCard(row, column).getName().equals("NULL_CARD")) {
        //     ; /** do nothing, there's already a card here*/
        // } else {
        //     //m_board.get(row).add(insertCard);
        //     m_board.get(row).set(column, insertCard);
        //     // System.out.println("card upkeep not implemented yet!");
        //     /** upkeep for card insertion here*/
        //     emptyBoard = false;
        // }
        System.out.println("Reached set card for: " + insertCard.getName());
        m_board.get(row).set(column, insertCard);
        System.out.println("Reached after set card for: " + m_board.get(row).get(column).getName());

        emptyBoard = false;
    }

    public Boolean isBoardEmpty() {
        return emptyBoard;
    }

    public boolean[][] getValidPlantSpaces() {
        if (isBoardEmpty()) {


            return boardState;
        }
        else {

            for (int c = 0; c < 4; c++){
                for (int v = 0; v < 4; v++) {
                    boardState[c][v] = false;
                }
            }

            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    System.out.print(boardState[a][b] + " ");
                }
                System.out.println();
            }


            System.out.println();
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    if (!getCard(a, b).getName().equals(VALID_PLANTING)) {
                        boardState[a][b] = true;
                    }
                }
            }

            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    System.out.print(boardState[a][b] + " ");
                }
                System.out.println();
            }




            System.out.println();
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    if (!getCard(a, b).getName().equals(VALID_PLANTING)) {
                        for (int x = a-1; x < a+3; x++){
                            for (int y = b-1; y < b+3; y++) {
                                if (x >= 0 && y >= 0 && x < 4 && y < 4) { boardState[x][y] = true; }
                            }
                        }
                    }
                }
            }
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    System.out.print(boardState[a][b] + " ");
                }
                System.out.println();
            }



            System.out.println();
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    if (!getCard(a, b).getName().equals(VALID_PLANTING)) {
                        boardState[a][b] = false;
                    }
                }
            }

            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    System.out.print(boardState[a][b] + " ");
                }
                System.out.println();
            }

            return boardState;
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
        if (m_board.size() == 4)
            for (int x = 0; x < 4; x++)
            {
                if (m_board.get(x).size() != 4) { return false; }
            }
        return true;
    }
}
