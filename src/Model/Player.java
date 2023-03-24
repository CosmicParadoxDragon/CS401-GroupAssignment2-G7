package Model;

import java.util.Vector;

import Model.Cards.Card;

public class Player {
    String playerName = "John Smith";
    
    int soil;
    int gainedSoil = 0;
    int gainedCards = 0;

    Card m_islandCard, m_climateCard;
    Vector <Card> hand;
    Vector <Card> compostPile;
    Vector <Card> discardPile;
    Vector <Card> eventStack;
    Vector<Vector <Card>> playerTabulue;
    Game m_game;
    public String getName()
    {
        return playerName;
    }
    Player(Game currentGame)
    {
        hand = new Vector<Card>();
        compostPile = new Vector<Card>();
        m_game = currentGame;

        playerTabulue = new Vector<Vector <Card>>();
    }
    public Vector <Card> getHand()
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
            compostPile.add(discardPile.lastElement());
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
}
