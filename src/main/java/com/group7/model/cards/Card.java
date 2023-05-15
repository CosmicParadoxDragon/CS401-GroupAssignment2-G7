package com.group7.model.cards;

import java.util.ArrayList;
import java.util.Stack;

public class Card {
    public final static String NULL_CARD = "NULL_CARD";
    String m_name, m_abilitiesLine, m_text;
    int m_victoryPoints;
    ArrayList <AbilityPair> m_encodedAbilities;
    
    Card() {  }

    // Used for the Null Card
    public Card(String name) { m_name = name; }
    
    Card(String name, String abilityLine, int victoryPoints)
    {
        m_name = name;
        m_abilitiesLine = abilityLine;
        m_victoryPoints = victoryPoints;
        m_encodedAbilities = new ArrayList<AbilityPair>();
        encodeAbilities();
    }

    Card(String name, String abilityLine)
    {
        m_name = name;
        m_abilitiesLine = abilityLine;
        m_encodedAbilities = new ArrayList<AbilityPair>();
        // encodeAbilities();

    }

    Card(String name, String type, String text, int victoryPoints)
    {
        m_name = name;
        m_abilitiesLine = text;
        m_victoryPoints = victoryPoints;

    }

    private void encodeAbilities() {
        // Sort by if card has an ability to activate
        String [] byColorSplit = m_abilitiesLine.split("'");

        for (String item : byColorSplit) {
            m_encodedAbilities.add(new AbilityPair(item));
        }
    }
    /**
     * @return the m_name
     */
    public String getM_name() {
        return m_name;
    }
    /**
     * @return the m_abilities
     */
    public ArrayList<AbilityPair> get_abilities() {
        return m_encodedAbilities;
    }
    /**
     * @return the m_text
     */
    public String getM_text() {
        return m_text;
    }
    public String getAbilityLine() { return m_abilitiesLine; }


}
