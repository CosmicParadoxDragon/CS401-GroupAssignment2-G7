package com.group7.model;

import java.util.ArrayList;
import java.util.Stack;

import com.group7.model.board.Tableau;
import com.group7.model.cards.Card;
import com.group7.model.cards.EarthCard;
import com.group7.model.cards.AbilityPair;


public class Player {
    String playerName = "John Smith";
    
    int soil;
    int gainedSoil = 0;
    int gainedCards = 0;
    int trunks = 0;
    int sprouts = 0;

    Card m_islandCard, m_climateCard;
    ArrayList <Card> hand;
    ArrayList <Card> compostPile;
    ArrayList <Card> discardPile;
    ArrayList <Card> eventStack;
    ArrayList<ArrayList <Card>> playerTabulue;
    Game m_game;
    Tableau m_tableau;


    public String getName()
    {
        return playerName;
    }
    Player(Game currentGame)
    {
        hand = new ArrayList<>();
        compostPile = new ArrayList<>();
        discardPile = new ArrayList<>();
        eventStack = new ArrayList<>();
        m_game = currentGame;
        m_tableau = new Tableau();
        playerTabulue = new ArrayList<ArrayList <Card>>();
    }
    public ArrayList <Card> getHand()
    {
        return hand;
    }
    void setIsland(Card islandCard)
    {
        m_islandCard = islandCard;
    }
    void setClimate(Card cliamteCard)
    {
        m_climateCard = cliamteCard;
    }

    // void placeCardontoTableau(int cardIndex) {
    //     ArrayList row = new ArrayList();
    //     row.add(hand.get(cardIndex));
    //     playerTabulue.add(row);
    // }

    public Boolean isBoardFilled(){
        if (playerTabulue.size() == 0) {
            return false;
        }
        for (ArrayList<Card> row : playerTabulue){
            for (Card column : row){
                if(column == null){
                    return false;
                }
            }
        }
        return true;
    }
    String takeTurn()
    {
        String actionChosen = "";

        //Choose an action
        // Switch to correct branch
        actionChosen = selectAction();

        switch (actionChosen)
        {
            case "planting":
                activePlanting(); break;
            case "composting":
                activeComposting(); break;
            case "growing":
                activeGrowing(); break;
            case "watering":
                activeWatering(); break;
        }

        return actionChosen;
    }
    
    String selectAction()
    {
        String action;// = "planting";
        action = m_game.getActionChoice();
        return action;
    }

    void activePlanting()
    {
        // Active Player Action
        // Plant 2 Cards
        plant();
        plant();
        // Draw 4 Discard 3 (not compost)
        // tableau.plant(Card, Card);
        for (int i = 0; i < 4; i++)
            hand.add(m_game.EarthDeck.dealCard());
        discard(3);
    }

    void takeInactiveAction(String inactiveAction)
    {
        switch (inactiveAction)
        {
            case "planting":
                inactivePlanting(); break;
            case "composting":
                inactiveComposting(); break;
            case "growing":
                inactiveGrowing(); break;
            case "watering":
                inactiveWatering(); break;
        }
    }
    
    void inactivePlanting()
    {
        // Gaia Action
        // discarded cards become compost
        for (int i = 0; i < 3; i ++)
        {
            compostPile.add(discardPile.get(discardPile.size()));
            compostPile.remove(discardPile.size());
        }
    }

    void plant()
    {
        Card cardToPlant;

        String message = "Select a card to plant.";
        // push message to GUI along with input for a number
        // Select a card from Hand

        // cardToPlant = m_game.m_control.getCardChoice();
        int x = 0,y = 0;
        // Place it in the Tabelu anywhere on first planting
        // only adjacent to existing cards after.
        String message = "Select a card to plant.";
        // push message to GUI along with input for a number

        // m_tableau.setCard(x, y, cardToPlant);
        
        // cardToPlant.get_abilities();

    }

    private int placeInIsland(Card card)
    {
        // Get a specific Tile number from tui
        // m_game.m_control.getIslandCoords();

        // 

        return 0;
    }


    void activeComposting()
    {
        
    }

    void inactiveComposting()
    {

    }

    void activeWatering()
    {

    }
    
    void inactiveWatering()
    {

    }

    void activeGrowing()
    {

    }

    void inactiveGrowing()
    {

    }


    // example ability section: 
    // Yellow:+1 Trunks +1 Sprouts
    void abilityParser(AbilityPair ability) // temporary location for the ability parser function
    {
        int num = 0;
        String number;
        String ability_text = ability.getText();
        String [] ability_split = ability_text.split(" ");
        for ( String word : ability_split )
        {
            if ( word.contains("then") )
            {
                // skip or stack maybe not sure if we need to stack abilities
                // like this in this context
            }
            if (word.contains("+") || word.contains("-"))
            {
                number = word.substring(1);
                num = Integer.valueOf(number);
            }
            else if ( word.contains("Trunks") )
            {
                trunks += num;
            }
            else if ( word.contains("Sprouts") )
            {
                sprouts += num;
            }
            else if ( word.contains("Soil") && num < 0)
            {
                soil += num;
            }
            else if ( word.contains("Soil") )
            {
                soil += num;
                gainedSoil += num; 
                // Soil gained need to be reset somewhere putting at the end of the turn for now
            }
            else if ( word.contains("Cards") )
            {
                for (int y = 0; y < num; y++)
                {
                    hand.add(m_game.EarthDeck.dealCard());
                }
            }
            else if ( word.contains("Compost") && num < 0)
            {
                // Move top most compost card to discard pile
            }
            else if ( word.contains("Compost") )
            {
                // Move a card to the compost pile
            }
        }
    }

    /**
     * @return the compostPile
     */
    public ArrayList<Card> getCompostPile() {
        return compostPile;
    }

    /**
     * @return the gainedSoil
     */
    public int getGainedSoil() {
        return gainedSoil;
    }

    /**
     * @return the eventStack
     */
    public ArrayList<Card> getEventStack() {
        return eventStack;
    }

    /**
     * @return the discardPile
     */
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    /**
     * @return the gainedCards
     */
    public int getGainedCards() {
        return gainedCards;
    }

    /**
     * @return the m_climateCard
     */
    public Card getM_climateCard() {
        return m_climateCard;
    }

    /**
     * @return the m_islandCard
     */
    public Card getM_islandCard() {
        return m_islandCard;
    }

    /**
     * @return the playerTabulue
     */
    public ArrayList<ArrayList<Card>> getPlayerTabulue() {
        return playerTabulue;
    }

    /**
     * @return the soil
     */
    public int getSoil() {
        return soil;
    }

    // Public for testing purposes
    public void discard(int numberToDiscard)
    {
        for ( int i = 0; i < numberToDiscard; i++)
        {
            if (hand.size() == 0) { return; } // No discard possible, should never reach this from 
            // the way the game is designed but you never know so its here.
            Card someCardToDiscard;
            someCardToDiscard = m_game.getController().getCardChoice();
            // someCard = getHand().get(0); // TODO way to select a card from the hand
            hand.remove(someCardToDiscard);
        }
    }
}
