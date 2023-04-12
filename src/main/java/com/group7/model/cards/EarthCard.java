package com.group7.model.cards;

public class EarthCard extends Card
{
    String m_type;
    int m_cost, m_victoryPoints;
    
    EarthCard(String name, String abilityLine, int cost, int victoryPoints)
    {
        super(name, abilityLine);
        m_cost = cost;
        m_victoryPoints = victoryPoints;
    }
}
