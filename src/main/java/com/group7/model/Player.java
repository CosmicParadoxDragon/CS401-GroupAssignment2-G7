package com.group7.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import com.group7.model.board.Tableau;
import com.group7.model.cards.Card;
import com.group7.model.cards.AbilityPair;


public class Player {
    String playerName = "John Smith";
    
    int soil;
    int gainedSoil = 0;
    int gainedCards = 0;

    Card m_islandCard, m_climateCard;
    ArrayList <Card> hand;
    ArrayList <Card> compostPile;
    ArrayList <Card> discardPile;
    ArrayList <Card> eventStack;
    Tableau playerTableau;
    Game m_game;
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

        playerTableau = new Tableau();
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

    void placeCardontoTableau(int row, int collumn, Card cardDrawn) {
        playerTableau.setCard(row, collumn, cardDrawn);
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
                activePlanting();
                break;
            case "composting":
                activeComposting();
                break;
            case "growing":
                activeGrowing();
                break;
            case "watering":
                activeWatering();
                break;
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
        // Plant Up to 2 cards
        // Then draw the same number of cards that you plant
        plant();
        // tableau.plant(Card, Card);
        for (int i = 0; i < 4; i++)
            hand.add(m_game.EarthDeck.dealCard());
        discard(3);
    }
    
    void inactivePlanting()
    {
        // Other players may plant one card and draw one card
        for (int i = 0; i < 3; i ++)
        {
            compostPile.add(discardPile.get(discardPile.size()));
            compostPile.remove(discardPile.size());
        }
    }

    void plant()
    {
        // Select a card from Hand
        // Place it in the Tabelu anywhere on first planting
        // only adjacent to existing cards after.
        String message = "Select a card to plant.";
        // push message to GUI along with input for a number
        


    }
    void activeComposting()
    {
        //The active player gains five soil
        //setGainedSoil(2);
        // They also adds two cards from the deck to their
        //compost pile
//        compostPile.add
    }

    void inactiveComposting()
    {
        // Gain two soil or compost two card
    }

    void activeWatering()
    {
        // Gain up to six sprout and two soil
    }
    
    void inactiveWatering()
    {
        // Gain two sprout or two soil
    }

    void activeGrowing()
    {
        // Draw four card from the pile and add two growth token cards
    }

    void inactiveGrowing()
    {
        // Draw two card or gain two growth
    }

    void abilityParser(Stack<AbilityPair> theStack) // temporary location for the ability parser function
    {
        if (theStack.isEmpty())
            return;
        else
        {
            AbilityPair currentAbility = theStack.pop();
            if (currentAbility.getColor().equals("Black"))
            {
                
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
    public Tableau getPlayerTabulue() {
        return playerTableau;
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
            if (hand.size() == 0) {return;} // No discard possible, should never reach this from
            // the way the game is designed but you never know so its here.
            Card someCardToDiscard;
            someCardToDiscard = m_game.getController().getCardChoice();
            // someCard = getHand().get(0); // TODO way to select a card from the hand
            hand.remove(someCardToDiscard);
        }
    }
}
