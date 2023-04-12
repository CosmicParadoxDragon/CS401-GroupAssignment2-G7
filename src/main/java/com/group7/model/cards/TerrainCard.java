package com.group7.model.cards;

public class TerrainCard extends EarthCard
{
    String m_habitat;
    public TerrainCard(String name, String habitat, String abilityLine, int cost, int victoryPoints)
    {
        super(name, abilityLine, cost, victoryPoints);
        m_habitat = habitat;
        m_type = "Terrain";
    }
}
