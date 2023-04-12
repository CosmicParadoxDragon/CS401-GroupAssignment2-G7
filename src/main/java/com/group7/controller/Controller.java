
package com.group7.controller;

import com.group7.model.Game;
import com.group7.view.gameTui;

import java.io.IOException;

public class Controller {
    Game m_game;
    gameTui m_tui;

    public Controller() throws IOException
    {
        m_game = new Game(this, 1);
        m_tui = new gameTui(this);//this);
    }

    public Game getGame() { return m_game; }
    gameTui getTui() {return m_tui; }

    public String getActionChoice()
    {
        String action = "";

        // m_tui.promptForActionChoice();

        return action;
    }
}