package com.group7.model.board;

import com.group7.model.cards.Card;
import com.group7.view.PromptCards;

public class CardPair {
    private Card first;
    private Card last;
    private int x, y;
    public CardPair(Card first, Card last) {
        this.first = first;
        this.last = last;
    }
    public CardPair(int a, int b, Card first) {
        this.first = first;
        x = a;
        y = b;

    }
    public Card getFirst() {
        return first;
    }
    public Card getLast() {
        return last;
    }

    public int getX () {return x; }
    public int getY () {return y; }
}
