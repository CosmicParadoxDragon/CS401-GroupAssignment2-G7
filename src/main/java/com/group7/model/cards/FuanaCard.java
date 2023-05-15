package com.group7.model.cards;


import com.group7.model.Player;

import java.util.Vector;

public class FuanaCard extends Card
{
    Vector <Player> achievedPlayers = new Vector<Player>();
    public FuanaCard(String name, String abilityLine)
    {
        super(name, "Fuana", abilityLine, 0);
    }

    /**
     * 
     * @return the achievedPlayers
     */
    public Vector<Player> getAchievedPlayers() {
        return achievedPlayers;
    }

    String vpCondition = "2+ Columns in your Island are filled.  Earn 15 Victory Points";
    String programmaticVPCondition = "!E|2ic|v15";
    // Two Island Columns + 15 Victory Points

}