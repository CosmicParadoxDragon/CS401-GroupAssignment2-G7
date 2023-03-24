package Model;

// import java.util.Random;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Model.Cards.*;

public class Deck {
    Vector <Card> deckList;
            
    Deck() { deckList = new Vector<Card>(); /* Suppose to start by building a deck from a given file */ }

    Deck(String Test)
    {
        // this is exists to trigger the testing state deck 

    }

    Card dealCard()
    {   
        // Meant for setup call
        // return a random card from the deck
        // TODO make card draw irreplacable and get random cards
        // implement shuffle() function?

        return deckList.get(0);
    }

    /**
     * @return the deckList
     */
    public Vector<Card> getDeckList() {
        return deckList;
    }

    void fillEarthDeck() throws FileNotFoundException
    {
        File file;
        Scanner deck_file;

        try {
            file = new File("src/Model/Cards/decklists/terrain_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            String line = deck_file.nextLine();
            String []list = line.split(",");

            String name = list[0],
            habitat     = list[1],
            abilities   = list[2];
            int cost    = Integer.parseInt(list[3]),
            vp          = Integer.parseInt(list[4]);
            deckList.add(new TerrainCard(name, habitat, abilities, cost, vp));
            deck_file.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        // deckList.add(new TerrainCard("Prairie", "Sunny|Rocky|Cold", "Green:+1 Cards 3 Victory Points per Herb in this Row", 4, 2));
    }   

    void fillClimateDeck()
    {
        File file;
        Scanner deck_file;

        try {
            file = new File("src/Model/Cards/decklists/climate_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            String line = deck_file.nextLine();
            String []list = line.split(",");

            String name = list[0],
            habitat     = list[1],
            abilities   = list[3];
            int vp      = Integer.parseInt(list[2]);

            deckList.add(new ClimateCard(name, habitat, vp, abilities));
            deck_file.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    void fillFuanaDeck()
    {
        // Score this card Fuana ability  4 flora with >= 3 Trunks
        File file;
        Scanner deck_file;

        try {
            file = new File("src/Model/Cards/decklists/fuana_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            String line = deck_file.nextLine();
            String []list = line.split(",");

            String name = list[0],
            objective   = list[1];
            deckList.add(new FuanaCard(name, objective));
            deck_file.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    void fillIslandDeck()
    {
        // Ability line reads Black (on-play effect) draw 5, compost 2, and gain 7 soil.  Second ability: Green activated gain 2 sprouts per rocky
        // habitat flora planted this turn
        File file;
        Scanner deck_file;

        try {
            file = new File("src/Model/Cards/decklists/island_cards.csv");
            deck_file = new Scanner(file);
            deck_file.nextLine();
            deck_file.nextLine();
            deck_file.nextLine();
            String line = deck_file.nextLine();
            String []list = line.split(",");

            String name = list[0],
            habitat     = list[1],
            abilities   = list[3];
            int vp      = Integer.parseInt(list[2]);
            deckList.add(new IslandCard(name, habitat, vp, abilities));
            deck_file.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
