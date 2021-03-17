
import java.util.*;

public class DeckOfCards extends Cards{

    public Stack<Cards> deck = new Stack<>();


    public DeckOfCards()
    {
        //deck = new Stack<>();
        for(int i = 0; i < SUITS.length; i++)
        {
            for(int j = 0; j < FACES.length; j++)
            {
                deck.add(new Cards(SUITS[i], FACES[j]));
            }
        }
        Collections.shuffle(deck);

    }

    public DeckOfCards(String suit, String face){
        super(suit, face);
    }


    public String deckInfo(){
        String output = "";
        for(int i = 0; i < deck.size(); i++)
        {
            output += deck.elementAt(i).toString() + "\n";
        }
        return output;
    }




}
