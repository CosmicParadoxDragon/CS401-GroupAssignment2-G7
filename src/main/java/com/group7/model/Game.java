package com.group7.model;

import com.group7.model.cards.Card;
import com.group7.controller.Controller;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    Controller m_control;
    int m_numberOfPlayers;
    ArrayList <Card> FuanaCards;
    ArrayList <Integer> Scores;
    ArrayList <Player> players;
    Deck EarthDeck;
    Deck IslandDeck;
    Deck ClimateDeck;
    Deck FuanaDeck;
    Deck discardPile;
    boolean actionFlag = true;
    int turn = 0;
    Player activePlayer;
    Iterator<Player> iter;
    // For testing purposes
    public Game(int numberOfPlayers)
    {   
        EarthDeck = new Deck();
        IslandDeck = new Deck();
        ClimateDeck = new Deck();
        FuanaDeck = new Deck();
        discardPile = new Deck();
        FuanaCards = new ArrayList<Card>();
        Scores = new ArrayList<Integer>();
        players = new ArrayList<Player>();

        m_numberOfPlayers = numberOfPlayers;
        // Game Setup Phase
        SetupPhase();
        iter = players.iterator();
        activePlayer = getNextPlayer();
        // takeTurnZero(); // Island and Climate Setup
        mainTurnLoop(); // Take a regular turn, and being the checks for complete Island
    }

    // Set up the deck and player board
    public Game(Controller controller, int numberOfPlayers)
    {   
        m_control = controller;
        EarthDeck = new Deck();
        IslandDeck = new Deck();
        ClimateDeck = new Deck();
        FuanaDeck = new Deck();
        discardPile = new Deck();
        FuanaCards = new ArrayList<Card>();
        Scores = new ArrayList<Integer>();
        players = new ArrayList<Player>();
        m_numberOfPlayers = numberOfPlayers;
        for (int i = 0; i < m_numberOfPlayers; i++) {
            players.add(new Player(this));
        }
        playerSetup();

        // SetupPhase();
        // if ( numberOfPlayers == 1)
        //     SetupGaia();
        // GameStart();
    }
    public void GameStart() {
        actionFlag = true;
        // Players -> Turn 0 actions place island and climate onto board
        String action = "";
        // Stop turn Prompt user to place island and climate onto
        // game board.  Sanity check, could be automated won't be.
        // Card someCard = m_control.getCardChoice();
        getActivePlayer().takeTurnZero();

    }

    // Player now tak
    // public void gameStart() {
    //      playerSetup();
    //      // takeTurnZero(); // Island and Climate Setup
    //      mainTurnLoop(); // Take a regular turn, and being the checks for complete Island
    //  }

    public void takeATurn(){
        // Taking an nth turn
    }

    public void playerSetup() {
        iter = resetIterator();
        activePlayer = getNextPlayer();
    }
    // Assuming Solo Game
    public void SetupPhase()
    {
        try{
            EarthDeck.fillEarthDeck();
            ClimateDeck.fillClimateDeck();
            FuanaDeck.fillFuanaDeck();
            IslandDeck.fillIslandDeck();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        for (int j = 0; j<4; j++)
        {
            FuanaCards.add(FuanaDeck.dealCard());
        }
        // 1 Player game is standard expect everything to break
        // PlayerSetup();
    }

    
    public void PlayerSetup()
    {
        for (int i = 0; i < m_numberOfPlayers; i++)
        {
            Card island = IslandDeck.dealCard();
            players.get(i).getHand().add(island);
            // Activate the island immediate ability with black background
            // E.g: island.parseAbility("black");
            // island.parseAbilities(island.getM_abilities()) ;
            // This should work if parseAbility is complete
            players.get(i).getHand().add(ClimateDeck.dealCard());
            // players.get(i).getHand().add(EcosystemDeck.dealCard()); // if we ever get here
        }
    }

    void mainTurnLoop() {
        while (!isTableauDeckFilled()) {
            takeASingleTurn();
        }
    }

    public void takeASingleTurn() {
        // Edge case check
        // Reset the iterator if it reached the last element of the players list
        if (!iter.hasNext()) {
            iter = resetIterator();
        }
        if (m_numberOfPlayers != 1)
            activePlayer = iter.next();
        else {
            // The current Player taking turn
            String nextAction = activePlayer.takeTurn();
            // Now iterate to the other player and perform inactive action
            // The go back to the current player
            for (int i = 0; i < this.players.size(); i++) {
                if (!iter.hasNext()) {
                    iter = players.iterator();
                }
                iter.next().takeInactiveAction(nextAction);
            }
        }
        //Increment the turn and then iterate to the next player
        turn++;
    }

    Player getNextPlayer() {
        return iter.next();
    }

    Iterator<Player> resetIterator() {
        return players.iterator();
    }
    boolean isTableauDeckFilled() {
        for (Player currentPlayer : players) {
            if (currentPlayer.m_tableau.isBoardFilled()) {
                return true;
            }
        }
        return false;
   }

    String getActionChoice()
    {
        return m_control.getActionChoice();
    }
    
    public ArrayList<Card> getFuanaCards()
    {
        return FuanaCards;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    public Player getActivePlayer() {return activePlayer;}
    void planting()
    {
        // Active Player Action
        // Plant 2 Cards
        // Draw 4 Discard 3 (not compost)
        
        // Gaia Action
        // Your Discards move to compost

        // Trigger Green Abilities
    }

    void compostion()
    {
        // Player Action
        // Gain 5 Soil
        // Compost 2 Cards from the EarthDeck

        // Gaia Action
        // Compost 2 cards, Compost 1 for every 2 soil gained this turn

        // Trigger Red and Multicolored Abilities
    }

    void watering()
    {
        //Player Action
        // Gain 6 sprouts
        // May gain 2 soul

        // Gaia Action
        // you gain 1 sprout per red ability you have

        // Trigger all blue and multicolored abilities
    }
    
    void growing()
    {
        // Player Action
        // Draw 4 to hand
        // Place 2 growth

        // Gaia Action
        // gain 1 growth for each draw this turn

        // Trigger Yellow and Multicolored Abilities
    }

    /**
     * @return the climateDeck
     */
    public Deck getClimateDeck() {
        return ClimateDeck;
    }

    /**
     * @return the earthDeck
     */
    public Deck getEarthDeck() {
        return EarthDeck;
    }

    /**
     * @return the fuanaDeck
     */
    public Deck getFuanaDeck() {
        return FuanaDeck;
    }

    /**
     * @return the islandDeck
     */
    public Deck getIslandDeck() {
        return IslandDeck;
    }

    /**
     * @return the scores
     */
    public ArrayList<Integer> getScores() {
        return Scores;
    }

    /**
     * @return the m_numberOfPlayers
     */
    public int getM_numberOfPlayers() {
        return m_numberOfPlayers;
    }

    /**
     * @return the discardPile
     */
    public Deck getDiscardPile() {
        return discardPile;
    }

    public int getTurn() {
        return turn;
    }
    Controller getController() { return m_control; }
    public void flipActionFlag() { actionFlag = !actionFlag; }
}