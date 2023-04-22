package com.group7;

import org.junit.jupiter.api.Test;

import com.group7.controller.Controller;
import com.group7.model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

     // Testing setup phase completion
    Controller controller;
    Game game_state;    
    @BeforeEach
    void setupTest() throws IOException
    {
        controller = new Controller();
        Game game = new Game(controller, 1);
        game_state = game;
    }

    @Test
    void activePlayerTest()
    {
        assertEquals(game_state.getPlayers().get(0), game_state.getActivePlayer());
    }

    @Test
    void nillBoardStatePlayerArrayListsTest()
    {
        // Testing Zeroes everywhere we expect them
        // from arraylists
        assertEquals(0, game_state.getActivePlayer().getCompostPile().size());
        assertEquals(0, game_state.getActivePlayer().getDiscardPile().size());
        assertEquals(0, game_state.getActivePlayer().getEventStack().size());
    }

    @Test
    void nillBoardStatePlayerIntsTest()
    {
        // ints
        assertEquals(0, game_state.getActivePlayer().getGainedCards());
        assertEquals(0, game_state.getActivePlayer().getGainedSoil());
    }
    
    @Test
    void scoresAreZeroTest()
    {
        for (int score : game_state.getScores())
        {
            assertEquals(0, score);
        }
    }


    /*
     * Player Action Tests
     */

    // At the beginning of the game each player deal one island and one climate card
    @Test
    void playerDrawTest() {
        assertEquals(2, game_state.getActivePlayer().getHand().size());
    }
    @Test
    void playerDiscardActionTest() {
        game_state.getActivePlayer().discard(1);
        assertEquals(1, game_state.getActivePlayer().getHand().size());
    }

    /**
     * Game object Deck Tests Go here
     * Deck sizes are all one, decklists are made but currently we are not taking in 
     * more than a single card from each of the decklists
     */

    @Test
    void climateDeckSizeTest()
    {
        // After drawing
        assertEquals(20, game_state.getClimateDeck().getDeckList().size());
    }

    @Test
    void fuanaDeckSizeTest()
    {

        assertEquals(46, game_state.getFuanaDeck().getDeckList().size());
    }

    @Test
    void islandDeckSizeTest()
    {

        assertEquals(10, game_state.getIslandDeck().getDeckList().size());
    }

    @Test
    void discardSizeTest()
    {

        assertEquals(0, game_state.getDiscardPile().getDeckList().size());
    }


    // Complex Testing

    // need the takeTurn function
    // Test if the first player taking turn is the first player in the ArrayList
    @Test
    void takeTurnTest()
    {
        assertEquals(game_state.getActivePlayer(), game_state.getPlayers().get(0));
    }

    
}
