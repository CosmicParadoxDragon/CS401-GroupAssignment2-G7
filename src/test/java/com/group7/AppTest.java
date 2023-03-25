package com.group7;

import org.junit.jupiter.api.Test;

import com.group7.Model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

     // Testing setup phase completion
    Game game_state;    
    @BeforeEach
    void setupTest()
    {
        game_state = new Game(1);
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
        assertEquals(0, game_state.getActivePlayer().getPlayerTabulue().size());
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

        assertEquals(1, game_state.getClimateDeck().getDeckList().size());
    }

    @Test
    void fuanaDeckSizeTest()
    {

        assertEquals(1, game_state.getFuanaDeck().getDeckList().size());
    }

    @Test
    void islandDeckSizeTest()
    {

        assertEquals(1, game_state.getIslandDeck().getDeckList().size());
    }

    @Test
    void discardSizeTest()
    {

        assertEquals(0, game_state.getDiscardPile().getDeckList().size());
    }


    // Complex Testing

    //TODO need the takeTurn function


    
}
