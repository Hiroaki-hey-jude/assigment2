package assignment.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dealer {
	
	 private Deck deck;
	    private List<Player> players;
	    private final int NUMBER_OF_CARDS;

	    public Dealer(int numberOfCards, int numberOfPlayers) {
	        this.deck = new Deck(numberOfCards);
	        this.players = new ArrayList<>(numberOfPlayers);
	        this.NUMBER_OF_CARDS = numberOfCards;
	    }

	    public void shuffleDeck(){
	        Collections.shuffle(deck.getDeck());
	    }

	    public void dealShuffledCardsToPlayers(List<Player> players){
//	        List<Card> tempCard = deck.getDeck();
//	        for(int i=0; i < players.size(); i++){
//	            for(int j=0; j < 6; j++){
//	                players.add(tempCard.remove(i+j*6));
//	            }
//	        }
	        for(Player player: players){
	            player.setHand(deck.deal());
	        }
	    }
	    
	   /* public Map<Player, Card> PlayerCardMapping(List<Player> player, List<Card> card){
	    	
	    	Map<Player, Card> PlayerCardMap = new HashMap<Player, Card>();
	    	
	    	int numberOfCardsPerPlayer = card.size() / players.size();
	    	int reaminedCard = card.size() - (numberOfCardsPerPlayer * players.size());
	    	int i=0;
	    	
	    	for(Player play : player) {
	    		play.setHand(deck.deal(numberOfCardsPerPlayer));
	    	
	    	PlayerCardMap.put(player.get(i), play.getHand());
	    	
	    	}
	    	
	    	
	    	
	    	
	    	return PlayerCardMap;
	    } */


}
