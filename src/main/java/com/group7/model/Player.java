package com.group7.model;

import java.util.ArrayList;
import java.util.Random;

import com.group7.controller.Controller;
import com.group7.model.board.CardPair;
import com.group7.model.board.Tableau;
import com.group7.model.cards.Card;
import com.group7.model.cards.AbilityPair;


public class Player {
    String playerName = "John Smith";
    String BLACK = "Black";
    String YELLOW = "Yellow";
    String BLUE = "Blue";
    String GREEN = "Green";
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
    Tableau playerTableau;
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

    void placeCardOntoTableau(int row, int collumn, Card cardDrawn) {
        playerTableau.setCard(row, collumn, cardDrawn);
    }

    public Boolean isBoardFilled(){
        return playerTableau.isBoardFilled();
    }
    String takeTurn()
    {
        setGainedSoil(0);
        setGainedCards(0);

        String actionChosen = "";

        //Choose an action
        // Switch to correct branch
        actionChosen = selectAction();

        switch (actionChosen)
        {
            case Controller.PLANTING:
                activePlanting(); break;
            case "Composting":
                activeComposting(); break;
            case "Growing":
                activeGrowing(); break;
            case "Watering":
                activeWatering(); break;
        }

        return actionChosen;
    }

    public void takeTurnZero() {
        // Player placing the island and climate into their board
//        String action = "";
        // action = m_game.m_control.getGui().promptGeneric("Select a card to place in Island Slot: ");
        // Need to pause execution here to wait for response.
        Card islandCard = m_game.getController().promptForIsland();
        playIslandCard(islandCard);
        m_game.getController().redraw();

        Card climateCard = m_game.getController().promptForClimate();
        playClimateCard(climateCard);
        m_game.getController().redraw();

    }

    private void playIslandCard(Card islandCard) {

        setIsland(islandCard);
        hand.remove(islandCard);
        hand.trimToSize();
        m_game.m_control.redraw();

        for (AbilityPair resolveBlack : islandCard.get_abilities() ) {
            if (resolveBlack.getColor().equals(BLACK)) {
                abilityParser(resolveBlack);
            }
        }
        hand.trimToSize();
        m_game.m_control.redraw();
    }
    private void playClimateCard(Card climateCard ) {
        setClimate(climateCard);
        hand.remove(climateCard);
        hand.trimToSize();
    }

    String selectAction()
    {
        String action;// = "Planting";
        action = m_game.getActionChoice();
        return action;
    }
    void takeInactiveAction(String inactiveAction)
    {
        switch (inactiveAction)
        {
            case Controller.PLANTING:
                inactivePlanting(); break;
            case Controller.COMPOSTING:
                inactiveComposting(); break;
            case Controller.GROWING:
                inactiveGrowing(); break;
            case Controller.WATERING:
                inactiveWatering(); break;
        }
    }

    void activePlanting()
    {
        // Active Player Action
        // Plant 2 Cards
        plant();
        m_game.m_control.redraw();
        plant();
        m_game.m_control.redraw();
        // Draw 4 Discard 3 (not compost)
        // tableau.plant(Card, Card);
        for (int i = 0; i < 4; i++)
            hand.add(m_game.EarthDeck.dealCard());
        discard(3);
    }
    
    void inactivePlanting()
    {
        // Other players may plant one card and draw one card
        plant();
        hand.add(m_game.EarthDeck.dealCard());
    }

    void plant()
    {
        boolean plantFlag = m_game.m_control.promptYesNo("Would you like to plant?");
        if (plantFlag) {


            CardPair targetAndLocation = m_game.m_control.getPlantChoice();

            // push message to GUI along with input for a number
            // Select a card from Hand

            // cardToPlant = m_game.m_control.getCardChoice();
            int x = 0,y = 0;

            // Place it in the Tabelu anywhere on first planting
            // only adjacent to existing cards after.

            // TODO This card isn't setting right now
            m_tableau.setCard(targetAndLocation.getX(), targetAndLocation.getY(),
                    targetAndLocation.getFirst());

            hand.remove(targetAndLocation.getFirst());
            m_game.m_control.redraw();
            // targetAndLocation.getFirst().getAbilities();
        }
    }

    void activeComposting() {
        //The active player gains five soil
        setGainedSoil(2);
        // They also and adds two cards from the deck to their
        //compost pile
        compostPile.add(m_game.EarthDeck.dealCard());
        compostPile.add(m_game.EarthDeck.dealCard());
    }

    void inactiveComposting() {
        Random rand = new Random();
        // Gain two soil or compost two card
        // This should be performed randomly for now
        // TODO Implement controller prompting user to choose between gain soils or compost cards
        int choice = rand.nextInt(2) + 1;
        switch (choice) {
            case 1:
                setGainedSoil(2);
            case 2:
                compostPile.add(m_game.EarthDeck.dealCard());
        }
    }

    void activeWatering()
    {
        Random rand = new Random();
        // Gain up to 6 Sprout
        // Generated randomly (for now)
        // TODO Implement control prompting user how much sprout they want to gain
        setGainedSprout(rand.nextInt(6)+1);
        setGainedSoil(2);
    }
    
    void inactiveWatering()
    {
        Random rand = new Random();
        // Gain two sprout or two soil
        int choice = rand.nextInt(2) + 1;
        switch (choice) {
            case 1:
                setGainedSprout(2);
            case 2:
                setGainedSoil(2);
        }
    }

    void activeGrowing()
    {
        // Draw four card from the pile and put two growth on their Flora
        for (int i = 0; i < 4; i++) {
            m_game.EarthDeck.dealCard();
        }
        // Place 2 growth on any Flora
    }

    void inactiveGrowing()
    {
        // Draw two card or put two growth on their Flora
        Random rand = new Random();
        // Gain two sprout or two soil
        int choice = rand.nextInt(2) + 1;
        switch (choice) {
            case 1:
                m_game.EarthDeck.dealCard();
                m_game.EarthDeck.dealCard();
            case 2:
                // Place 2 growth on any non-full Flora card
        }
    }


    // example ability section:
    // Island Cards
    // Black:Cards +12 Compost +5 Soil +6'Green: +1
    // AbilityPair object contains Black and Cards +12 Compost +5 Soil +6
    void abilityParser(AbilityPair ability) // temporary location for the ability parser function
    {
        String [] individual_functions = ability.getText().split(" ");
        for ( int i = 0; i < individual_functions.length; i = i + 2 ) {
            if ( individual_functions [i+1].contains("+") || individual_functions [i+1].contains("-") ) {
                processAbilityIncreaseResource(individual_functions[i], individual_functions[i+1]);
            }
        }

    }
    private void processAbilityIncreaseResource(String resource, String directionAmount) {
        boolean isNegative = directionAmount.contains("-");
        String subDirectionAmount = directionAmount.substring(1);
        int amount = Integer.parseInt(subDirectionAmount);
        if (isNegative) {
            amount -= 2 * amount;
        }
        switch (resource) {
            case "Cards":
                hand.addAll(m_game.EarthDeck.draw(amount));
                gainedCards += amount;
                break;
            case "Compost":
                discard(amount);
                break;
            case "Soil":
                gainSoil(amount);
            case "Trunks":
                gainTrunks(amount);
                break;
            // case  :
        }
    }
    void gainSoil(int amount) {
        soil += amount;
        gainedSoil += amount;
    }
    void gainTrunks(int amount) {
        trunks += amount;
        // Nothing yet measures gainedTrunks but
        // imma put it here anyway
        // gainedTrunks += amount;
    }
    private void parseCardAbility(Card playedCard) {


    }

    private void setGainedCards(int amount) {
        gainedCards = amount;
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
    public Card getClimateCard() {
        return m_climateCard;
    }

    /**
     * @return the m_islandCard
     */
    public Card getIslandCard() {
        return m_islandCard;
    }

    /**
     * @return the playerTabulue
     */
    public Tableau getPlayerTableau() {
        return playerTableau;
    }

    /**
     * @return the soil
     */
    public int getSoil() {
        return soil;
    }

    // Public for testing purposes
    public void discard(int numberToDiscard) {
        ArrayList<Card> toRemove = m_game.m_control.getDiscardChoice(numberToDiscard);
        for (Card in : toRemove) {
            discardPile.add(in);
            hand.remove(in);

        }
        m_game.m_control.redraw();
    }
    void setGainedSoil(int amount) { soil+= amount; }
    void setGainedTrunk(int amount) { trunks += amount; }
    void setGainedSprout(int amount) { sprouts += amount; }

    public void setTableau(Tableau toSet) {
        m_tableau = toSet;
    }

}
