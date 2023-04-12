
package com.group7.controller;

import com.group7.model.Game;
import com.group7.view.gameTui;


public class Controller {
    Game m_game;
    gameTui m_tui;

    Controller()
    {
        m_game = new Game(this, 1);
        m_tui = new gameTui(this);//this);
    }



}