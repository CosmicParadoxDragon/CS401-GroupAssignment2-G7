# CS401-GroupAssignment1-G7

---

~~First~~ Third group assignment for the CS401 Class, Spring 2023 semester at CSUEB.

Game Setup
---
### Game
- Score Keeping
- Turn Clock
- Solo Mode
  > Simultaneous turns mean we can't do a hotseat multiplayer, and online is not worth including in a project of this scale.
- Win Conditions
    > Track fuana cards, probably can evaluate at the end of the game.
  
### Players
- Player Board
  - Leaf Token Track
    > Leaf tokens track which objective has been scored on. More relevant in multiplayer games, but the order is important because the first player or non-player who scores them achives more points.
  - Compost Pile
    > Cards that have been discarded here are face down no longer matter.
  - Soil Bank
    > Cards that cost soil to play need to make a check here that they player can afford to play them
- Island
    > The Island zone has one island card assigned before turn 1
- Cliamte
    > The this is a card slot for one card assignment made before turn 1
- Enviroment
    > A wincondition card that maybe implemented.
  
### Cards
- Earth Cards
  - Flora Cards
  - Event Cards
  - Terrain Cards
- Fuana Cards
  > These are pre-game cards that determine the victory conditions for the player
- Island Card
    > This is a card assigned at the beginning of the game and does not change after 
- Climate Cards
  > This is also a post-turn 1 static card
- Enviroment Cards
  > This is a post turn 1 static card, that doesn't interact besides informing the player an additional objective

    > The Game can be played without these cards so they will not be implemented until the other functionality exists.
- Abilities
  - Immeadiate Action
    > 'Black' bordered abilities in the images, these resolve when the card is played
  - Ongoing/Win Condition
    > This is a temporary term as a placeholder for abilities that are checked on an ongoing basis, primarily win condition abiliites that score you points. There will be a toggle on the card to stop the check once scored.
  - Triggered
    > These abilities are color coded and active after that action is taken in game.  Abilities with mutliple colors exist.  Abilities are activated at the end on each players the action on their turn.
  - Encoding Abilities
    > Need some way to encode abilities into patterns of characters so that we can use alphanumeric strings to build cards instead of hard coding them.
  - Need a csv file and accessors for the cards in normalized format
  

## Members
Sohrab Kazak

Truong Dinh

Jed Faalam

Jacob Smith
