package com.group7.Model.Cards;

public class AbilityPair {
  String m_item1, m_item2;
  AbilityPair(String item1, String item2) {
    m_item1 = item1;
    m_item2 = item2;
  }

  public String getColor() { return m_item1; }
  public String getText() { return m_item2; }
}
