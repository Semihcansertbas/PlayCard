package card;

import java.util.ArrayList;
import java.util.List;

public class Card {       
    
    public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
    public static final String[] RANKS = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

    private final String rank;
    private final String suit;
    private Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String rank() { return rank; }
    public String suit() { return suit; }
    public String toString() { return rank + " of " + suit; }

    private static final List<Card> protoDeck = new ArrayList<Card>();

 
    static {									     // Initialize prototype deck
        for (int i = 0; i < SUITS.length; i++)        
            for (int j = 0; j < RANKS.length; j++)
                protoDeck.add(new Card(RANKS[j], SUITS[i]));
    }

    public static ArrayList<Card> newDeck() {
        return new ArrayList<Card>(protoDeck);      // Return copy of prototype deck
    }
    
}

