
package main.java.com.group7.controller;

import main.java.com.group7.model.Game;
import main.java.com.group7.model.gameTui;


public class Controller {
    Game m_game;
    gameTui m_tui;

    Controller()
    {
        m_game = new Game(this, 1);
        m_tui = new gameTui(this);
    }



}