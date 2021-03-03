package assignment.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import assignment.cardgame.Card.Point;
import assignment.cardgame.Card.Suit;



public class Deck extends Hand {
	private List<Card> deck;
	private ArrayList<ArrayList<Card>> a;
	
	/* To Populate a deck
	 * Loop Suit
	 * 	Loop Points
	 * 		set card to Card(suit,point)
	 * 		CALL cards.add with card
	 */
	 public Deck (int numberOfCards) {
		 deck = new ArrayList<>(numberOfCards);
		for(Suit suit: Suit.values()) {
			for(Point point: Point.values()) {
				Card card = new Card(suit, point);
				deck.add(card);
				//System.out.println("Inside populate " + card);
			}
		}
	}
	
	public List<Card> getDeck(){
        return deck;
    }
	
	
	public ArrayList<Card> deal(){
		int size = 17;
        ArrayList<Card> hand = new ArrayList<>(size);
        Random rand = new Random();
        int s = deck.size();
        System.out.println("printing deck size "+ s);
        int c=0;
        for (int dealtCount = 0; dealtCount < size; dealtCount++) {
            hand.add(deck.remove(rand.nextInt(deck.size())));
            c++;
        }
        System.out.println("printing counter "+ c);
        System.out.println("Remaining card "+ (s- c));
        if((s-c) ==1) {
        	hand.add(deck.remove(0));
        }
     //   ArrayList<ArrayList<Card>> a = new ArrayList<ArrayList<Card>>(); 
     //   a.add(hand);
        return hand;
    }
	
	public ArrayList<ArrayList<Card>> putHandIn2D(ArrayList<Card> hand){
		hand = deal();
		this.a = new ArrayList<ArrayList<Card>>(); 
		a.add(hand);
		Card[][] stringArray = a.stream().map(u -> u.toArray(new Card[0])).toArray(Card[][]::new);
		System.out.println();
		return null;
	}
	
	
	 public String toString(){
	        String result = "";
	        for(int i = 0; i < a.size(); i++){
	            for(int j = 0; j < a.get(i).size(); j++){
	                result += a.get(i).get(j);
	            }
	            System.out.println();
	        }
	        return result;
	    }
	
	
	
	public Set<Card> shuffle() {
	
		//Set<Card> cards = new HashSet<Card>(Arrays.asList());
				//cards = new HashSet<Card>(Arrays.asList());
				List<Card> cardsList = new ArrayList<>(cards);
				System.out.println("Inside shuffle " + cardsList );
				Collections.shuffle(cardsList);
				System.out.println("\nShuffled Deck : \n"   + cardsList); 
				return new LinkedHashSet<Card>(cardsList);
					
				//for(Card c : cardsList)
					//this.add(c);
				
				//this.addList(cardsList);
				//cards.clear();
				//cards.addAll(cardsList);
				//this.addList(cardsList);
				//cardsList.addAll(cards);						
		}
	
	
	public static Player[] dealCards(Player[] players, Card[] deck) {
        int numOfCardsPerPlayer = deck.length / players.length;
        for (int i = 0; i < deck.length; i++) {
            int positionInHand = i % numOfCardsPerPlayer;
            players[i % players.length].receiveCard(deck[i], positionInHand);
        }

        return players;
    }
	
	/*  @Override
	    public String toString(){
	        StringBuilder builder = new StringBuilder();
	        for(int i = 0; i < deck.size(); i++){
	            builder.append(i + " ");
	            builder.append(deck.get(i));
	            builder.append(System.getProperty("line.separator"));
	        }
	        return builder.toString();
	    } */

	
	
	
	
	}
	
	
	/*private Card[] cards = new Card[52];
	
	public Deck() {
		refill();
	}
	
	public final void refill() {
		int i=0;
		for(Suit suit : Suit.values()){
			 for(Point point : Point.values()) {
				 cards[i++] = new Card(suit, point);
			 }
		}
	}*/
	
	/*public Card drawCard() {
		
	}*/


 