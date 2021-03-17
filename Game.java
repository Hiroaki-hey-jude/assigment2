import java.util.*;
public class Game{
	public static boolean numOfPlayer3 = true;
	public ArrayList<Player> players = new ArrayList<>();
	public ArrayList<Cards> hand = new ArrayList<>();
	public static boolean shuffleDone = false;
	public ArrayList<Cards> handOfPlayer1 = new ArrayList<>();
	public static void main(String[] args){
		DeckOfCards deck = new DeckOfCards();
		Game game = new Game();
		Player player = new Player();
		System.out.println("******************");
		System.out.println("* 3-Player Phase *");
		System.out.println("******************");
		game.createPlayers();

		System.out.println();
		game.distribution1(deck.deck, game.players);
		game.shuffleDeck(deck.deck);
		player.pointOfEachCards(deck.deck);
		game.battle1(player.getFullInfoCards(), deck.deck);
		game.whoWillGoHell();

		DeckOfCards deck2 = new DeckOfCards();
		System.out.println();
		System.out.println("******************");
		System.out.println("* 2-Player Phase *");
		System.out.println("******************");
		System.out.println();
		game.distribution1(deck2.deck, game.players);
		game.shuffleDeck(deck2.deck);
		player.pointOfEachCards(deck2.deck);
		game.battle2(player.getFullInfoCards(), deck2.deck);
		game.whoWillWin();

	}
	public List<Player> createPlayers(){
		Scanner scanner = new Scanner(System.in);
		for(int i = 1; i < 4; i++)
		{
			System.out.print("Please enter " + i + " name: ");
			String playerName = scanner.next();
			players.add(new Player(playerName));
		}
		return players;
	}
	private int getLongest(int min, int max) {
		int l = 0;
		for (int i = min; i < max; i++) {
			String str = players.get(i).getName();
			if (l < str.length())
				l = str.length();
		}
		return l;
	}
	public ArrayList<Cards> player1(Stack<Cards> deck){

		if(deck.size() == 52)
		{
			for(int i = 0; i < 14; i++)
			{
				hand.add(deck.get(i));
			}
			return hand;
		}
		return null;
	}

	public void distribution1(Stack<Cards> deck, ArrayList<Player> players){
		ArrayList<Cards> playerHand1 = new ArrayList<>();
		ArrayList<Cards> playerHand2 = new ArrayList<>();
		ArrayList<Cards> playerHand3 = new ArrayList<>();
		if(players.size() == 3) {
			if (deck.size() == 52) {
				for (int i = 0; i < 18; i++)
					playerHand1.add(deck.get(i));
				for (int i = 18; i < 35; i++)
					playerHand2.add(deck.get(i));
				for (int i = 35; i < 52; i++)
					playerHand3.add(deck.get(i));
			} else if (deck.size() == 37) {
				for (int i = 0; i < 13; i++)
					playerHand1.add(deck.get(i));
				for (int i = 13; i < 25; i++)
					playerHand2.add(deck.get(i));
				for (int i = 25; i < 37; i++)
					playerHand3.add(deck.get(i));
			} else if (deck.size() == 22) {
				for (int i = 0; i < 8; i++)
					playerHand1.add(deck.get(i));
				for (int i = 8; i < 15; i++)
					playerHand2.add(deck.get(i));
				for (int i = 15; i < 22; i++)
					playerHand3.add(deck.get(i));
			} else if (deck.size() == 7) {
				for (int i = 0; i < 3; i++)
					playerHand1.add(deck.get(i));
				for (int i = 3; i < 5; i++)
					playerHand2.add(deck.get(i));
				for (int i = 5; i < 7; i++)
					playerHand3.add(deck.get(i));
			}
			players.get(0).setHand(playerHand1);
			players.get(1).setHand(playerHand2);
			players.get(2).setHand(playerHand3);
			System.out.println("Available Cards");
			String format = "%-" + this.getLongest(0, 3) + "s";
			for (int i = 0; i < 3; i++) {
				System.out.println(String.format(format, players.get(i).getName())+ toString(players.get(i).getHand()));
			}
		}else
		{
			if (deck.size() == 52) {
				for (int i = 0; i < 26; i++)
					playerHand1.add(deck.get(i));
				for (int i = 26; i < 52; i++)
					playerHand2.add(deck.get(i));
			}else if (deck.size() == 42){
				for(int i = 0; i < 21; i++)
					playerHand1.add(deck.get(i));
				for(int i = 21; i < 42; i++)
					playerHand2.add(deck.get(i));
			}else if (deck.size() == 32) {
				for (int i = 0; i < 16; i++)
					playerHand1.add(deck.get(i));
				for (int i = 16; i < 32; i++)
					playerHand2.add(deck.get(i));
			}else if (deck.size() == 22) {
				for(int i = 0; i < 11; i++)
					playerHand1.add(deck.get(i));
				for(int i = 11; i < 22; i++)
					playerHand2.add(deck.get(i));
			}else if (deck.size() == 12) {
				for (int i = 0; i < 6; i++)
					playerHand1.add(deck.get(i));
				for (int i = 6; i < 12; i++)
					playerHand2.add(deck.get(i));
			}
			players.get(0).setHand(playerHand1);
			players.get(1).setHand(playerHand2);

			System.out.println("Available Cards");

			String format = "%-" + this.getLongest(0, 2) + "s";
			for (int i = 0; i < 2; i++) {
				System.out.println(String.format(format, players.get(i).getName()) + toString(players.get(i).getHand()));
			}
		}

	}
	private String toString(List<Cards> hand) {
		String str = ": ";
		int i = 0;
		for (Cards st : hand) {
			if(i==4 || i==9 || i==14 | i==19 | i==24) {
				str = str + st.getSuit() + st.getFace();
				str = str + ", ";
				i++;
			}else{
				str = str + st.getSuit() + st.getFace() + " ";
				i++;
			}

		}
		return str.substring(0, str.length() - 1);
	}


	public void shuffleDeck(Stack<Cards> deck)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Press s, if you want to shuffle the deck, press g if you wanna go on");
		String userInput = input.nextLine();
		switch (userInput)
		{
			case "s":
				Collections.shuffle(deck);
				distribution1(deck, players);
				break;
			case "g":
				break;
			default:
				System.out.println("Inappropriate input, please do it again");
				shuffleDeck(deck);
				break;


		}
	}

	public void battle1(Map<Cards, Integer> fullInfoCards, Stack<Cards> deck)
	{
		Player player = new Player();
		int l = 1;
		int count = 1;
		do {
			int n = 3;
			ArrayList<Cards>[] fiveCardsOfHand = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				fiveCardsOfHand[i] = new ArrayList<Cards>();
			}

			System.out.println();
			System.out.println("*** ROUND " + l + " ***");
			System.out.println("Cards at Hand:");

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					fiveCardsOfHand[i].add(players.get(i).getHand().get(j));
				}
			}

			int[] points = new int[4];
			int PlayerMax = points[0];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					if (fullInfoCards.containsKey(fiveCardsOfHand[i].get(j))) {
						if (fiveCardsOfHand[i].get(j).getSuit() == "c") {
							points[0] = points[0] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else if (fiveCardsOfHand[i].get(j).getSuit() == "d") {
							points[1] = points[1] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else if (fiveCardsOfHand[i].get(j).getSuit() == "h") {
							points[2] = points[2] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else {
							points[3] = points[3] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						}
					}
				}

				for (int k = 0; k < 4; k++) {
					if (PlayerMax < points[k]) {
						PlayerMax = points[k];
					}
				}
				players.get(i).setPoint(PlayerMax);
				for (int t = 0; t < 4; t++)
					points[t] = 0;
				PlayerMax = 0;
			}


			String format = "%-" + this.getLongest(0, 3) + "s";
			for (int i = 0; i < 3; i++) {
//                Player p = players.get(i);
				Collections.sort(fiveCardsOfHand[i], new sortBySuits());
				Collections.sort(fiveCardsOfHand[i], new sortByFace());
				System.out.println(String.format(format, players.get(i).getName()) + ":" + showHand(fiveCardsOfHand[i]) + " | Point = " + players.get(i).getPoint());
			}
			findWin1();
			distribution1(deck, players);
			Scanner input = new Scanner(System.in);
			String c = "";
			if (count < 3) {
				if(c == c) {
					System.out.println("Please input c to continue");
					c = input.nextLine();
					count++;
				}
			}
			l++;
		}while(l < 4);




	}


	public void battle2(Map<Cards, Integer> fullInfoCards, Stack<Cards> deck)
	{
		int l = 1;
		int count = 1;
		do {
			int n = 2;
			ArrayList<Cards>[] fiveCardsOfHand = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				fiveCardsOfHand[i] = new ArrayList<Cards>();
			}

			System.out.println();
			System.out.println("*** ROUND " + l + " ***");
			System.out.println("Cards at Hand:");

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 5; j++) {
					fiveCardsOfHand[i].add(players.get(i).getHand().get(j));
				}
			}

			int[] points = new int[4];
			int PlayerMax = points[0];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 5; j++) {
					if (fullInfoCards.containsKey(fiveCardsOfHand[i].get(j))) {
						if (fiveCardsOfHand[i].get(j).getSuit() == "c") {
							points[0] = points[0] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else if (fiveCardsOfHand[i].get(j).getSuit() == "d") {
							points[1] = points[1] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else if (fiveCardsOfHand[i].get(j).getSuit() == "h") {
							points[2] = points[2] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						} else {
							points[3] = points[3] + fullInfoCards.get(fiveCardsOfHand[i].get(j));
							deck.remove(fiveCardsOfHand[i].get(j));
						}
					} else
						System.out.println("oh no, something wrong i guess, try modify code!!");
				}

				for (int k = 0; k < 4; k++) {
					if (PlayerMax < points[k]) {
						PlayerMax = points[k];
					}
				}
				players.get(i).setPoint(PlayerMax);
				for (int t = 0; t < 4; t++)
					points[t] = 0;
				PlayerMax = 0;
			}


			String format = "%-" + this.getLongest(0, 2) + "s";
			for (int i = 0; i < 2; i++) {
				Collections.sort(fiveCardsOfHand[i], new sortBySuits());
				Collections.sort(fiveCardsOfHand[i], new sortByFace());
				System.out.println(String.format(format, players.get(i).getName()) + ":" + showHand(fiveCardsOfHand[i]) + " | Point = " + players.get(i).getPoint());
			}
			findWin2();
			distribution1(deck, players);
			Scanner input = new Scanner(System.in);
			String c = "";

			if (count < 4) {
				if(c == c) {
					System.out.println("Please input c to continue");
					c = input.nextLine();
					count++;
				}
			}

			l++;
		}while(l < 5);
	}

	public String showHand(List<Cards> hand)
	{
		String str = " ";
		for (Cards st : hand)
			str = str + st.getSuit() + st.getFace() + " ";
		return  str;
	}

	public void findWin1(){
		int highest = 0;
		int i = 0;
		highest = players.get(0).getPoint();

		if(highest < players.get(1).getPoint()) {
			highest = players.get(1).getPoint();
			i++;
		}
		if(highest < players.get(2).getPoint()) {
			highest = players.get(2).getPoint();
			i = 2;
		}

		players.get(i).setScore(players.get(i).getScore() + highest);
		System.out.println(players.get(i).getName() + " win!!!! congrats");

		System.out.println();
		String format = "%-" + this.getLongest(0, 3) + "s";
		System.out.println("Score:");
		for(int index = 0; index < 3; index++)
			System.out.println(String.format(format, players.get(index).getName()) + ":" + players.get(index).getScore());

		System.out.println();

	}

	public void findWin2(){
		int highest = 0;
		int i = 0;
		highest = players.get(0).getPoint();

		if(highest != players.get(1).getPoint()) {
			if (highest < players.get(1).getPoint()) {
				highest = players.get(1).getPoint();
				i++;
			}
			players.get(i).setScore(players.get(i).getScore() + highest);
			System.out.println(players.get(i).getName() + " win!!!! congrats");
		}else{
			players.get(0).setScore(players.get(0).getScore() + highest);
			players.get(1).setScore(players.get(1).getScore() + highest);
			System.out.println(players.get(0).getName() + "and" + players.get(1).getName() + " win!!!!, congrats");
		}
		System.out.println();
		String format = "%-" + this.getLongest(0, 2) + "s";
		System.out.println("Score:");
		for(int index = 0; index < 2; index++)
			System.out.println(String.format(format, players.get(index).getName()) + ":" + players.get(index).getScore());

		System.out.println();

	}

	public void whoWillGoHell()
	{
		int min = players.get(0).getScore();
		int index = 0;
		for (int i = 1; i < 3; i++)
		{
			if (min > players.get(i).getScore())
			{
				min = players.get(i).getScore();
				index = i;
			}
		}
		players.remove(index);
		System.out.println("***** " + players.get(0).getName() + " and " + players.get(1).getName() + " proceed to 2-Player phase *****");
	}

	public void whoWillWin()
	{
		if(players.get(0).getScore() < players.get(1).getScore())
			System.out.println("***** " + players.get(1).getName() + " is the WINNER! *****");
		else
			System.out.println("***** " + players.get(0).getName() + " is the WINNER! *****");
	}









}
