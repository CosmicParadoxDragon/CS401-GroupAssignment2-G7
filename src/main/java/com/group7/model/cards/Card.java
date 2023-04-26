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
    }

    Card(String name, String abilityLine)
    {
        m_name = name;
        m_abilitiesLine = abilityLine;
        m_encodedAbilities = new ArrayList<AbilityPair>();
    }

    Card(String name, String type, String text)
    {
        m_name = name;
        m_abilitiesLine = text;
        m_encodedAbilities = new ArrayList<AbilityPair>();
    }

    /**
     * Will check the passed turn action and return the ability string for the 
     * activated ability of the card can be used.
     // @param encodedString
     * @return a stack of ability operations to perform
     */
    Stack<AbilityPair> stackAbility(String colorOfTurnAction)
    {
        Stack<AbilityPair> abilityStack = new Stack<>();
        for ( AbilityPair ability : m_encodedAbilities )
        {
            if (ability.getColor().equals(colorOfTurnAction))
            {
                abilityStack.push(ability);
            }
        }
        return abilityStack;
    }

    public void parseAbilities(String encodedString)
    {
        // where the ability string will be passed to
        // needs color check -> defining actions -> resolution
        
        // Black:+12 Cards +5 Compost +6 Soil'Green:+1 Card Per Terrain Planted This Turn
        String[] text_abilities = encodedString.split("'");
        for (int i = 0; i < text_abilities.length; i++ )
        {
            String [] ability = text_abilities[i].split(":");
            m_encodedAbilities.add(new AbilityPair(ability[0], ability[1]));
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


}
