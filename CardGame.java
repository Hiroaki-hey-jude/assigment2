package assignment.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CardGame implements Game{
	

	private List<Card> cards;
	
	private List<Player> players = new ArrayList<Player>();
	
	//private Map<Player, List<Card>> cardsPlayersMap = new HashMap<Player,List<Card>>();
		
	private int numberOfPlayers = 3;
	
	private int numberOfCards = 52;
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public List<Player>getPlayers(){
		return players;
	}
	
	public CardGame() {
		cards = Card.getPackOfCards();
	}
	
	
	 public void createDeck(List<Player> players){

	        Dealer newDeck = new Dealer(numberOfCards, numberOfPlayers);
	        newDeck.shuffleDeck();
	        newDeck.dealShuffledCardsToPlayers(players);
	    }
	 
	 public List<Player> createPlayers(){
	        Scanner scanner = new Scanner(System.in);
	       
	            int count = 0, i = 0;
	            while (count < numberOfPlayers) {
	                System.out.println("Enter player "+(i+1)+" name : ");
	                String playerName = scanner.next();
	                players.add(new Player(playerName));
	                count++; 
	                i++;
	            }
	            return players;
	 }
	 
	 
/*	public Map<Player, List<Card>> distributeCardsForPlayers(List<Player> players) {
		this.players = players;
		
		if(cardsPlayersMap.size()==0)
			cardsPlayersMap.clear();
		
		int m = 0;
		for(Player pl : players) {
			pl.setPoints(0);
			List<Card> c = new ArrayList<Card>();
			int cardLimit = m + numberOfPlayers;
			for(int i=m; m<cardLimit; i++) {
				c.add(cards.get(i));
			}
			m = cardLimit;
			cardsPlayersMap.put(pl,c);
		}
		return cardsPlayersMap;
		
	}*/
	
	@Override
	public void playGame() {
		//for(int i =0;i<)
		
	}

	@Override
	public void displayWinners() {
		// TODO Auto-generated method stub
		
	}

}
