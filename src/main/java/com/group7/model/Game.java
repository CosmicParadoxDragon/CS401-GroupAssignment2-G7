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

    int turn = 0;
    Player activePlayer;

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
        // if ( numboerOfPlayers == 1)
        //         SetupGaia();

        activePlayer = players.get(0);
        // takeTurnZero(); // Island and Climate Setup
        mainTurnLoop(); // Take a regular turn, and being the checks for complete Island
    }
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
        // Game Setup Phase
        SetupPhase();
        // if ( numboerOfPlayers == 1)
        //         SetupGaia();

        //activePlayer = players.get(0);
        Iterator<Player> iter = players.iterator();
        activePlayer = iter.next();
        // takeTurnZero(); // Island and Climate Setup
        //mainTurnLoop(iter); // Take a regular turn, and being the checks for complete Island
    }

    //! Assumeing Solo Game
    private void SetupPhase()
    {
        try{
            EarthDeck.fillEarthDeck();
            ClimateDeck.fillClimateDeck();
            FuanaDeck.fillFuanaDeck();
            IslandDeck.fillIslandDeck();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        for (int i = 0; i < m_numberOfPlayers; i++)
        {
            players.add(new Player(this));
        }

        for (int j = 0; j<4; j++)
        {
            FuanaCards.add(FuanaDeck.dealCard());
        }
        // 1 Player game is standard expect everything to break
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
    void mainTurnLoop(Iterator<Player> iter) {
        while (!isTableauDeckFilled()) {
            if (!iter.hasNext()) {
                iter = players.iterator();
            }
            String nextAction = activePlayer.takeTurn();
            if (nextAction == "composting") {
                if (!EarthDeck.isEmpty()) {
                    EarthDeck.compostCard();
                }
                else {
                    // There no card left to compost
                    continue;
                }
            }
            turn++;
            activePlayer = iter.next();
        }
    }
    boolean isTableauDeckFilled() {
        for (Player currentPlayer : players) {
            if (currentPlayer.playerTableau.isBoardFilled()) {
                return true;
            }
        }
        return false;
    }
    void mainTurnLoop() {
        // This is purely for GUI purpose
        boolean TableauDeckisFilled = false;
        // End game condition
        // If a player tableau is filled and everyone has taken the same no_of_turn
        // The game is completed
        while (!TableauDeckisFilled) {
            for (Player currentPlayer : players) {
                // Checking if the tableau is filled
                // This line will use the getTableau function
                if (currentPlayer.playerTableau.isBoardFilled()) {
                    TableauDeckisFilled = true;
                }
                    currentPlayer.takeTurn();
//                    currentPlayer.placeCardontoTableau(0,0,Card);
                    // Can calculate the player point in here
                turn++;
            }
            // Declare the winner based on their points
        }
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

        // Trugger Red and Multicolored Abilities
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
    Controller getController() { return m_control; }
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
    
}