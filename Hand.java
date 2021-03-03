package assignment.cardgame;

import java.util.HashSet;
import java.util.Set;


/* This is a super class, forms the basis of 
 * all hands including deck */
public class Hand {
	public Set<Card> cards;
	
	public Hand() {
		cards = new HashSet<Card>();
	}
	
	
	public void clear() {
		cards.clear();
	}
	
	public void add(Card card) {
		cards.add(card);
	}
	
	/*public void addList(Collection<? extends Card> cardlist) {
		cards.addAll(cardlist);
	}*/
	
	public String showHand() {
		String str = "";
		for(Card c: cards) {
			str += c.toString() + "  ";
		}
		
		return str;
	}
	
	public boolean remove(Card card, Hand otherhand) {
		if(!cards.contains(card)) {
			return false;
		}
		else {
			cards.remove(card);
			otherhand.add(card);
			return true;
		}
	}

}
