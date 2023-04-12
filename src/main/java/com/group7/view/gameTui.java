package com.group7.view;

import com.group7.model.cards.Card;
import com.group7.model.Game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import static com.googlecode.lanterna.gui2.Window.Hint.FULL_SCREEN;

public class gameTui {

    Terminal terminal;
    Screen screen;
    TextGraphics tGraphics;
    MultiWindowTextGUI gameWindows;
    GridLayout gameLayout;
    Panel gameGrid;
    gameWindow mainGameWindow;
    Game game;

    int tColSize = 132; //number of terminal columns
    int tRowSize = 43; //number of terminal rows
    ArrayList<Card> handCards; //cards in hand
    ArrayList<Card> viewHandCards; //cards in hand that are currently on screen
    int viewHandMax = 6; //how many cards will be displayed on screen at once
    int viewHandIndex = 0; //keeps track of what cards should be in view

    ArrayList<Card> viewTableau; //cards in viewable Tableau

    ArrayList<Card> HabIsl; //current habitat and island cards

    public gameTui(Game game) throws IOException {
        this.game = game;

        //Initialize TUI layers
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(tColSize, tRowSize)).createTerminal();
        //screen size is hardcoded. The more dynamic layout managers make it difficult to ensure that
        //each element is in the correct location. I don't see this as a big issue, but it could potentially be changed
        //later with some effort if needed.
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        gameWindows = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        mainGameWindow = new gameWindow();
        mainGameWindow.setHints(Arrays.asList(FULL_SCREEN));
        //Creates fullscreen panel for main game UI

        gameGrid = new Panel(new AbsoluteLayout());
        //creates a grid that allows elements to be placed at specific locations

        handCards = game.getActivePlayer().getHand(); //get cards from active player
        viewHandCards = new ArrayList<Card>(); //cards that are currently in view

        //DEBUG to help test card scrolling
        for (int i = 0; i < 8; i++){
            handCards.add(handCards.get(0));
        }

        refreshScreen();
        //initial draw

    }

    private class gameWindow extends BasicWindow{
        public gameWindow(){
            super("Player Name");
        }
    }
    public void refreshScreen(){

        drawGrid();
        infoPanel();
        drawHand();

        mainGameWindow.setComponent(gameGrid);
        gameWindows.addWindowAndWait(mainGameWindow);
    }

    private void infoPanel(){

        int infoStartCol = 0;
        int infoStartRow = 0;

        int infoColSize = 45;
        int infoRowSize = 34;

        drawBorder(infoStartCol, infoStartRow, infoColSize, infoRowSize, "Game Info");
        drawCardSlots(infoStartCol+1,infoStartRow+1,2,1,HabIsl);
    }
    private void drawGrid(){
        int gridCol = 46;
        int gridRow = 0;

        drawBorder(gridCol,gridRow,miniCard.getCardColSize()*4+2 ,miniCard.getCardRowSize()*4+2, "Tableau");
        drawCardSlots(gridCol + 1,gridRow + 1,4,4, viewTableau);
    }

    private void drawHand(){
        int gridCol = 0;
        int gridRow = tRowSize - miniCard.getCardRowSize() -2;

        drawBorder(0,gridRow,tColSize -2,miniCard.getCardRowSize()+2, "Hand");

        // buttons for scrolling through cards
        Panel prev = new Panel();
        Panel next = new Panel();

        //this next bit is a hardcoded mess

        //button functions for scrolling.
        prev.addComponent(new Button("Prev", new Runnable() {
            @Override
            public void run() {
                viewHandIndex = viewHandIndex - viewHandMax;
                if (viewHandIndex < 0){
                    viewHandIndex = 0;
                }
                refreshScreen();
            }
        }));
        next.addComponent(new Button("Next", new Runnable() {
            @Override
            public void run() {
                viewHandIndex = viewHandIndex + viewHandMax;
                refreshScreen();
            }
        }));

        //sets position of pre/next buttons.
        prev.setPosition(new TerminalPosition(1, tRowSize - 3));
        prev.setSize(new TerminalSize(6, 5));

        next.setPosition(new TerminalPosition(tColSize - 9, tRowSize - 3));
        next.setSize(new TerminalSize(6,5));


        //if next/previous cards aren't available, buttons are not added to display
        if (handCards.size() > viewHandIndex + viewHandMax){
            gameGrid.addComponent(next);
        }

        if (viewHandIndex != 0) {
            gameGrid.addComponent(prev);
        }


        //center hand display
        gridCol = (tColSize - (miniCard.getCardColSize() * viewHandMax)) / 2;

        getHandView();
        //populates viewHandCards
        drawCardSlots(gridCol,gridRow + 1,viewHandCards.size(),1, viewHandCards);
    }

    private void getHandView(){
        //gets the cards that should be in view and places them in viewHandCards

        int cardsToGet;

        //clears viewable cards
        if (viewHandCards != null){
        viewHandCards.clear();
        }

        //changes how many cards to get if there are less cards in hand than the max viewable
        if (handCards.size() < viewHandIndex + viewHandMax){
            cardsToGet = handCards.size() - viewHandIndex;
        }
        else {
            cardsToGet = viewHandMax;
        }

        //Places desired cards in viewHandCards
        for (int i = 0; i < cardsToGet; i++){
            viewHandCards.add(handCards.get(viewHandIndex + i));
        }

    }
    private void drawCardSlots(int startCol, int startRow, int cols,int rows, ArrayList<Card> drawnCards){

        int cardIndex = 0;
        //used to iterate through card slot panels

        miniCard curCard;
        //temporary miniCard for creating slots

        for (int i = 0; i < rows; i++){
            for( int j = 0; j < cols; j++){
                if (drawnCards == null){
                    curCard = new miniCard();
                }
                else if (cardIndex >= drawnCards.size()){
                    curCard = new miniCard();
                }
                else {
                    curCard = new miniCard(drawnCards.get(cardIndex));
                }
                //if a card isn't found in the vector, generate empty card slot

                curCard.setCardPosition(startCol + (miniCard.getCardColSize()) * j, startRow + (miniCard.getCardRowSize()) * i);
                //sets card position

                gameGrid.addComponent(curCard.getPanel());
                cardIndex++;
            }
        }
    }

    private void drawBorder(int startCol, int startRow, int borderColSize, int borderRowSize, String title){
        //Draws borders around display elements

        Panel borderContainer = new Panel();
        Panel borderPanel = new Panel();

        borderContainer.setLayoutManager(new BorderLayout());
        borderContainer.setSize(new TerminalSize(borderColSize, borderRowSize));
        borderContainer.setPosition(new TerminalPosition(startCol, startRow));

        borderContainer.addComponent(borderPanel.withBorder(Borders.singleLine(title)));

        gameGrid.addComponent(borderContainer);
    }
}





