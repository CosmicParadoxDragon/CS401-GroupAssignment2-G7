package com.group7.model;

// import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import com.group7.model.cards.*;

public class Deck {
    Deck() {
        /* Suppose to start by building a deck from a given file */
        deckList = new ArrayList<Card>();
    }
    ArrayList <Card> deckList;

    Card dealCard()
    {
        if (deckList.size() == 0) {
            System.out.println("Deck Size 0");
            return new Card("NULL");
        }
        else {
            // Return a random card from the deck
            Random random = new Random();
            int cardDrawnIndex = random.nextInt(deckList.size() - 1);

            Card drawnCard = deckList.get(cardDrawnIndex);
            // Remove the card from the deck
            deckList.remove(cardDrawnIndex);
            deckList.trimToSize();
            // The shuffle the remaining cards
            // Collections.shuffle(deckList);
            return drawnCard;
        }
    }

    /**
     * @return the deckList
     */
    public ArrayList<Card> getDeckList() {
        return deckList;
    }

    void fillEarthDeck() throws FileNotFoundException
    {
        File file;
        Scanner deck_file;

        try {
            file = new File("src/main/java/com/group7/model/cards/decklists/terrain_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            while (deck_file.hasNext()) {
                String line = deck_file.nextLine();
                String[] list = line.split(",");

                String name = list[0],
                        habitat = list[1],
                        abilities = list[2];
                int cost = Integer.parseInt(list[3]),
                        vp = Integer.parseInt(list[4]);
                deckList.add(new TerrainCard(name, habitat, abilities, cost, vp));
            }
            deck_file.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // deckList.add(new TerrainCard("Prairie", "Sunny|Rocky|Cold", "Green:+1 cards 3 Victory Points per Herb in this Row", 4, 2));
    }   

    void fillClimateDeck()
    {
        File file;
        Scanner deck_file;

        try {
            file = new File("src/main/java/com/group7/model/cards/decklists/climate_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            while (deck_file.hasNext()) {
                String line = deck_file.nextLine();
                String[] list = line.split(",");

                String name = list[0],
                        habitat = list[1],
                        abilities = list[3];
                int vp = Integer.parseInt(list[2]);

                deckList.add(new ClimateCard(name, habitat, vp, abilities));
            }
            deck_file.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    void fillFuanaDeck()
    {
        // Score this card Fuana ability  4 flora with >= 3 Trunks
        File file;
        Scanner deck_file;

        try {
            file = new File("src/main/java/com/group7/model/cards/decklists/fuana_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();

            while (deck_file.hasNext()) {
                String line = deck_file.nextLine();
                String[] list = line.split(",");

                String name = list[0],
                        objective = list[1];
                deckList.add(new FuanaCard(name, objective));
            }
            deck_file.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    void fillIslandDeck()
    {
        // Ability line reads Black (on-play effect) draw 5, compost 2, and gain 7 soil.  
        // Second ability: Green activated gain 2 sprouts per rocky
        // habitat flora planted this turn
        File file;
        Scanner deck_file;


        try {
            file = new File("src/main/java/com/group7/model/cards/decklists/island_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            while (deck_file.hasNext()) {
                String line = deck_file.nextLine();
                String[] list = line.split(",");

                String name = list[0],
                        habitat = list[1],
                        abilities = list[3];
                int vp = Integer.parseInt(list[2]);
                deckList.add(new IslandCard(name, habitat, vp, abilities));
            }
            deck_file.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Action needed for composting. Remove two card on top of the deck
    void compostCard() {
        deckList.remove(deckList.size()-1);
        deckList.remove(deckList.size()-1);
    }
    public boolean isEmpty () { return deckList.isEmpty();}

    public ArrayList<Card> draw(int numOfCards){
        ArrayList<Card> result = new ArrayList<>();
        for  (int i = 0; i < numOfCards; i++) {
            result.add(dealCard());
        }
        return result;
    }
}
