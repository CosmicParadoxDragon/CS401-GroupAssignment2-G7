package com.group7.model.cards;

public class EventCard extends EarthCard
{
    public EventCard(String name, String abilityLine, int victoryPoints)
    {
        super(name, abilityLine, 0, victoryPoints);
        m_type = "Event";
    }
}
