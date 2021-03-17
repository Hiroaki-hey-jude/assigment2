
import java.util.*;
public class Player {
	private String playerName;
	private int score;
	private int point;
	private ArrayList<Cards> hand;
	private Map<Cards, Integer> fullInfoCards = new HashMap<>();
	//private Map<Stack<Cards>, Integer> fullInfoCards = new HashMap<>();

	public Player() {

	}

	public Player(String name){
		this.playerName = name;
		this.score = 0;
		this.point = 0;
		this.hand = new ArrayList<>();
		this.fullInfoCards = new HashMap<>();
	}

	public String getName(){
		return playerName;
	}

	public void setName(String name){
		this.playerName = name;
	}

	public int getScore(){
		return score;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getPoint()
	{
		return point;
	}

	public void setPoint(int point)
	{
		this.point = point;
	}

	public void setHand(ArrayList<Cards> hand) {
		this.hand = hand;
	}

	public List<Cards> getHand() {
		return hand;
	}


	public Map<Cards, Integer> getFullInfoCards() {
		return fullInfoCards;
	}

	public void setFullInfoCards(ArrayList<Cards> hand) {
		this.fullInfoCards = fullInfoCards;
	}


	public void pointOfEachCards(Stack<Cards> deck)
	{
		for(int i = 0; i < deck.size(); i++)
		{
			if(deck.get(i).getFace() == "A")
				fullInfoCards.put(deck.get(i), 1);
			else if(deck.get(i).getFace() == "2")
				fullInfoCards.put(deck.get(i), 2);
			else if(deck.get(i).getFace() == "3")
				fullInfoCards.put(deck.get(i), 3);
			else if(deck.get(i).getFace() == "4")
				fullInfoCards.put(deck.get(i), 4);
			else if(deck.get(i).getFace() == "5")
				fullInfoCards.put(deck.get(i), 5);
			else if(deck.get(i).getFace() == "6")
				fullInfoCards.put(deck.get(i), 6);
			else if(deck.get(i).getFace() == "7")
				fullInfoCards.put(deck.get(i), 7);
			else if(deck.get(i).getFace() == "8")
				fullInfoCards.put(deck.get(i), 8);
			else if(deck.get(i).getFace() == "9")
				fullInfoCards.put(deck.get(i), 9);
			else if(deck.get(i).getFace() == "X")
				fullInfoCards.put(deck.get(i), 10);
			else if(deck.get(i).getFace() == "J")
				fullInfoCards.put(deck.get(i), 10);
			else if(deck.get(i).getFace() == "Q")
				fullInfoCards.put(deck.get(i), 10);
			else if(deck.get(i).getFace() == "K")
				fullInfoCards.put(deck.get(i), 10);




		}
	}

}
class sortByFace implements Comparator<Cards> {

	@Override
	public int compare(Cards o1, Cards o2) {
		return o1.getSuit().compareTo(o2.getSuit());
	}
}
class sortBySuits implements Comparator<Cards>{
	public int compare (Cards a, Cards b)
	{
		return a.getSuitValue() - b.getSuitValue();
	}
}
