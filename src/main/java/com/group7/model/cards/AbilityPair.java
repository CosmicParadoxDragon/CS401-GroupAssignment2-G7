package com.group7.model.cards;

public class AbilityPair {
    String m_color, m_text;
    AbilityPair(String item1, String item2)
    {
        m_color = item1;
        m_text = item2;
    }
    public AbilityPair(String wholeLine) {
        String [] forExtractionColor = wholeLine.split(":");
        m_color = forExtractionColor[0];
        m_text = forExtractionColor[1];
    }

    public String getColor () { return m_color; }
    public String getText () { return m_text; }
}
