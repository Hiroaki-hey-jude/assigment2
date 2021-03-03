package assignment.cardgame;


import java.util.List;

public class CardGameApp {

	public static void main(String[] args) {
		 
		 CardGame cg = new CardGame();
		 List<Player> players = cg.createPlayers();
		 
		 if(players != null){
	            cg.createDeck(players);
	            
	            int i=0;
	            for (Player player: players){
	            		
	            		System.out.print(players.get(i++) + ": ");
	            		
	                    player.showHand();
	                    System.out.println();
	                   
	            }
	        }
		 
		 
		 //Players[] playersWithCards = Dealer.dealCards(players, shuffledCards);
		
		/*Card c1, c2;
		
		c1 = new Card(Suit.HEARTS, Point.ACE);
		c2 = new Card(Suit.DIAMONDS, Point.FIVE);
		
		System.out.println(c1.toString() + "\n" + c2.toString());
		
		//c1.flipCard();
		//c2.flipCard();
		
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		h1.add(c1);
		h1.add(c2);
		System.out.println("Showing Hands for H1 : " + h1.showHand());
		h1.remove(c1, h2);
		System.out.println("Hand 1 is : "+h1.showHand()  + "Hand 2 is now : "+h2.showHand());*/
		
		
		//Deck d1 = new Deck();
		//d1.populate();
		//System.out.println("Deck has following Card "+ d1.showHand());
		
		//d1.shuffle();
		//System.out.println("Deck after shuffling "+ d1.showHand());
		
		//System.out.println("After flipping ");
		//System.out.println(c1.toString() + "\n" + c2.toString());
		
		
		
		
		

		//cg.createDeck(players);
		
		/*ArrayList<Players> pName = new ArrayList<>();
		
		for(int i=0;i<pName.size();i++) {
			System.out.println("Enter player "+i+" name : ");
			players.setPlayerName(in.nextLine());
			pName.add(players);
		}   */
		
		
		
		
		//List<Card> c = new ArrayList<>();
		//c = Card.getPackOfCards();
		//System.out.println(c);
		
		//List<Players> pl = new ArrayList<>();
		//System.out.println("Distributing cards ");
		//System.out.print(cg.distributeCardsForPlayers(pl));
		
		
		
	}

}
