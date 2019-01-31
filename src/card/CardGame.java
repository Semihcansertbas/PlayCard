package card;

import java.util.*;
public class CardGame {
	
	public static void main(String[] args) {
        CardGame cg = new CardGame();
        
        Player p1 = cg.new Player("Semih");
        Player p2 = cg.new Player("Matthew");
        Player p3 = cg.new Player("John");
   //   Player p4 = cg.new Player("Tony");
        
        cg.addPlayer(p1);
        cg.addPlayer(p2);
        cg.addPlayer(p3);
   //   cg.addPlayer(p4);
        
        cg.shuffle();
        cg.deal();
        System.out.println(cg);
    }
	
	
	
    public class Player{
        private String name;
        public ArrayList<Card> cards = new ArrayList<Card>();
        
        public Player(String name){
            this.name = name;
        }
        
        public void addCard(Card c){
            cards.add(c);
        }
        
        public String toString(){
           return "Player Name: " + name + "\n" + cards.toString() + "\n" + "Total Cards: " + cards.size() + "\n";
        }
    }
    
    
    private ArrayList<Card> deck = Card.newDeck();
    private ArrayList<Player> players = new ArrayList<Player>();
    
    
    public ArrayList<Player> getPlayer(){     //getter for players ArrayaList
    	return players;
    }
   
    
    public void deal(){                      //distributing cards to the players
        if (players.size() == 0)
            System.out.println("No players..");
        for (int i = 0; i < deck.size(); i++){
            players.get(i%players.size()).addCard(deck.get(i));
        }
    }
    
    
    
    public void addPlayer(Player p){         //adds a player to players ArrayList
        players.add(p);
    }
    
    public String toString(){
        String s = "Card Game\n";
        for (int i = 0; i < players.size(); i++){
            s += players.get(i).toString();
        }
        return s;
    }
    
     public ArrayList<Card> shuffle(){        //shuffles the deck
            ArrayList<Card> randomDeck = new ArrayList<Card>();
            //pick a random number between 0 & protoDeck.size().
            //move that element to the randomDeck and remove from protoDeck..
            Random rand = new Random();
            while (!deck.isEmpty()){
                int r = rand.nextInt(deck.size());
                randomDeck.add(deck.get(r));
                deck.remove(r);
            }
            this.deck = randomDeck;
            return randomDeck;
    }
        
}

