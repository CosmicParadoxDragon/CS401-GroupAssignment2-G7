package com.group7.model.cards;

public class IslandCard extends Card
{
    String m_habitat;
    public IslandCard(String name, String habitat, int victoryPoints, String abilityLine)
    {
        super(name, abilityLine, victoryPoints);
        m_habitat = habitat;
    }

    
}
