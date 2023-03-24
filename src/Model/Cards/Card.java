package Model.Cards;

public class Card {
    String m_name, m_abilities, m_text;
    int m_victoryPoints;
    Card() {  }
    
    Card(String name, String abilityLine, int victoryPoints)
    {
        m_name = name;
        m_abilities = abilityLine;
        m_victoryPoints = victoryPoints;
    }

    Card(String name, String abilityLine)
    {
        m_name = name;
        m_abilities = abilityLine;
    }

    Card(String name, String type, String text)
    {
        m_name = name;
        m_text = text;
    }

    void parseAbilities(String abilityEncoding)
    {
        // where the ability string will be passed to
        // needs color check -> defining actions -> resolution

        /**
         * A very basic and honestly needlessly complex encoding standard for abilities
         * 
         * ! = new ability start
         * | = means "and" or "and then"  
         * colors = G Y B R Br
         * end game ability = E is skipped and counted at the end with victory points
         * d[x] = draw x cards
         * g[x] = add x growth
         * s[x] = add x sprouts
         * i[x] = gain x soil
         * h = herb
         * r = row, o = orthoganal
         * E[x] = end game ability
         * Format is : !{solor/End}{ability code}
         * ex:Y|g-5|d7 means Yellow ability then remove 5 growth and then draw 7
         */

         //! TODO This.
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
    public String getM_abilities() {
        return m_abilities;
    }
    /**
     * @return the m_text
     */
    public String getM_text() {
        return m_text;
    }
}
