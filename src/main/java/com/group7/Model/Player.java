package com.group7.Model;

import java.util.ArrayList;
import java.util.Stack;

import com.group7.Model.Cards.Card;
import com.group7.Model.Cards.AbilityPair;


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
    ArrayList<ArrayList <Card>> playerTabulue;
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
        String action = "planting";
        return action;
    }

    void activePlanting()
    {
        // Active Player Action
        // Plant 2 Cards
        // Draw 4 Discard 3 (not compost)

        // tableau.plant(Card, Card);
        for (int i = 0; i < 4; i++)
            hand.add(m_game.EarthDeck.dealCard());

        discard(3);
    }
    // Public for testing purposes
    public void discard(int numberToDiscard)
    {
        for ( int i = 0; i < numberToDiscard; i++)
        {
            Card someCard;
            someCard = getHand().get(0); // TODO way to select a card from the hand
            hand.remove(someCard);
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
    public ArrayList<ArrayList<Card>> getPlayerTabulue() {
        return playerTabulue;
    }

    /**
     * @return the soil
     */
    public int getSoil() {
        return soil;
    }
}
