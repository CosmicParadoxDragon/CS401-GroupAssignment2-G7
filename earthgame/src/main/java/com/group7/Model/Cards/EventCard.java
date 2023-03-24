package com.group7.Model.Cards;

public class EventCard extends EarthCard {
  public EventCard(String name, String abilityLine, int victoryPoints) {
    super(name, abilityLine, 0, victoryPoints);
    m_type = "Event";
  }
}
