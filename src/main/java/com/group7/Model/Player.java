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
        hand = new ArrayList<Card>();
        compostPile = new ArrayList<Card>();
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
    void discard(int numberToDiscard)
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
}
