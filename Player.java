package assignment.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	
	private int points;
	private String result;
	private String playerName;
	private List<Card> hand;
	
	private Card[] cards = new Card[13];
	
	Scanner in = new Scanner(System.in);
	

	public Player() {
		
	}
	
	public Player(String name) {
		this.playerName = name;
		this.points = 0;
		this.hand = new ArrayList<>();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return playerName;
	}
	
	 void receiveCard(Card card, int position){
	        cards[position] = card;
	    }
	 
	 public void setHand(List<Card> hand) {
	        this.hand = hand;
//	        System.out.println(hand);
	    }
	 
	 public List<Card> getHand() {
		return hand;
	}

	public void showHand(){
	        for(int i=0; i<this.hand.size(); i++){
	            System.out.print(this.hand.get(i)+" ");
	            if(i==4 || i==9 || i==14) {
	            	System.out.print(", ");
	            }
	        }
	 }
	 
	 public void ShowPlayerCards(){
	        System.out.println("---------------------------------------------");
	        for (Card card : cards){
	            if(card!=null)
	                System.out.println(card.point + "  of  " + card.suit);
	        }
	        System.out.println("---------------------------------------------");
	    }

	/*
	void inputPlayName() {
		ArrayList<String> pName = new ArrayList<>();
		for(int i=1;i<4;i++) {
			System.out.println("Enter player "+i+" name : ");
			playerName = in.nextLine();
			pName.add(playerName);
		}
	}
*/
}
