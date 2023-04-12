package com.group7.model.cards;

public class FloraCard extends EarthCard
{
    String m_subtype, m_habitat;
    int m_sprouts, m_growth;
    int m_sproutsMax, m_growthMax, m_canopyScore;
    
    /**
     * Constructor for Flora Cards
     * @param name Plant Name
     * @param subtype None|Tree|Herb|Mushroom|Bush|All
     * @param habitat None|Sunny|Wet|Rocky|Cold|All
     * @param abilityLine This is stupib and will most likely not work out in the long run
     * @param cost soil cost 
     * @param sproutsMax Maximum sprouts allowed on the card
     * @param growthMax max growth counters allowed on the card 
     * @param victoryPoints victory points for playing
     */
    public FloraCard(String name, String subtype, String habitat, String abilityLine, int cost, int sproutsMax, int growthMax, int victoryPoints, int canopyScore)
    {
        super(name, abilityLine, cost, victoryPoints);
        m_subtype = subtype;
        m_habitat = habitat;
        m_sproutsMax = sproutsMax;
        m_growthMax = growthMax;
        m_type = "Flora";
        m_sprouts = 0;
        m_growth = 0;
        m_canopyScore = canopyScore;
    }
    
}
