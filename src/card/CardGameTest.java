package card;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import card.CardGame.Player;

public class CardGameTest {
	
	
	
	@Test
	public void testCardGame() {
		CardGame cg = new CardGame();
        
        Player p1 = cg.new Player("Semih");
        Player p2 = cg.new Player("Matthew");
        Player p3 = cg.new Player("John");
        Player p4 = cg.new Player("Tony");
        
        cg.addPlayer(p1);
        cg.addPlayer(p2);
        cg.addPlayer(p3);
        cg.addPlayer(p4);
        Assert.assertEquals(4, cg.getPlayer().size());
        
        
        ArrayList<Card> original = Card.newDeck();
		CardGame test = new CardGame();
		ArrayList<Card> shuffled = test.shuffle();
		Assert.assertNotEquals(original, shuffled);
     
		
        cg.shuffle();
        cg.deal();
        
        for(int i = 0; i < 4; i++) {         // testing if each player gets 13 cards
        	Assert.assertEquals(13, cg.getPlayer().get(i).cards.size());
        }
		
	}
	
	

}
