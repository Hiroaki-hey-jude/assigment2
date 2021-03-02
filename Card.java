package assignment.cardgame;

import java.util.ArrayList;
import java.util.List;


public class Card {
	
	
	/* An enum type is a special data type that enables for a variable to be set of predefined constants */
	
	//Every Card has a suit. Hearts, Clubs, Diamonds, Spades
	enum Suit {
		HEARTS("h"), 
		DIAMONDS("d"), 
		CLUBS("c"), 
		SPADES("s");
		
		private final String suitText;
		
		private Suit(String suitText) {
			this.suitText = suitText;
		}
		
		public String printSuit() {
			return suitText;
		}
	}
	
	/*Every Card has a Rank(its point)
	 * ACE = 1,
	 * Number Cards = 2 to 10
	 * Face Cards(Jack, Queen, King) = 10
	 * Each Card can be face up or face Down
	 */
	enum Point {
		ACE(1,"A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
		NINE(9, "9"), TEN(10, "X"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");
		
		private final int value;
		private final String valueString;
		private Point(int value, String valueString ) {
			this.value = value;
			this.valueString = valueString;
		}
	};
	
	public int getPoint() {
		return value;
	}
	
	public final Suit suit;
	public final String suitText;
	public final Point point;
	public final int value;
	public final String valueString;
	
	
	public Card(Suit suit, Point point) {
		this.suit = suit;
		this.suitText = suit.suitText;
		this.point = point;
		this.value = point.value;
		this.valueString = point.valueString;
	}
	
	public static List<Card> getPackOfCards(){
		List<Card> cardlist = new ArrayList<Card>();
		
		for(Suit suit: Suit.values()) {
			for(Point point: Point.values()) {
				Card card = new Card(suit, point);
				cardlist.add(card);
			}
		}
		return cardlist;
	}

	@Override
	public String toString() {
		String str = "";
			str += suitText.toString()+valueString.toString();
		return str;
	}
	
	

}
