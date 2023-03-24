package com.group7.Model;

import com.group7.Model.Cards.Card;

import java.util.ArrayList;

public class Game {

    int m_numberOfPlayers;
    ArrayList <Card> FuanaCards;
    ArrayList <Integer> Scores;
    ArrayList <Player> players;
    Deck EarthDeck;
    Deck IslandDeck;
    Deck ClimateDeck;
    Deck FuanaDeck;
    Deck discardPile;

    Player activePlayer;

    Game(int numberOfPlayers)
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
        // mainTurnLoop(); // Take a regular turn, and being the checks for complete Island

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
            //island.parseAbilities(island.getM_abilities()) ;
            // This should work if parseAbility is complete
            players.get(i).getHand().add(ClimateDeck.dealCard());
            // players.get(i).getHand().add(EcosystemDeck.dealCard()); // if we ever get here
        }
    }

    void mainTurnLoop()
    {
        // This is purely for GUI purpose
        int no_of_turn = 0;
        boolean TableauDeckisFilled = false;
        // End game condition
        // If a player tableau is filled and everyone has taken the same no_of_turn
        // The game is completed
        while (!TableauDeckisFilled) {
            for (Player currentPlayer : players) {
                // Checking if the tableau is filled
                // This line will use the getTableau function
                // if (currentPlayer.getTableau().isBoardFilled()) {
                //    TableauDeckisFilled = true;
                //}
                System.out.printf("Now it is player %s turn. \n", currentPlayer.getName());
                currentPlayer.takeTurn();
                // Can calculate the player point in here
            }
            no_of_turn++;
        }
        // Declare the winner based on their points
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
}