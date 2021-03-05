import java.util.ArrayList;
import java.util.Stack;

public class DeckOfCards {
   public final String[] FACES = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
   public final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
   Stack<Cards> deck = new Stack<>();
   public DeckOfCards()
   {
       deck = new Stack<>();
       for(int i = 0; i < SUITS.length; i++)
       {
           for(int j = 0; j < FACES.length; j++)
           {
               deck.add(new Cards(SUITS[i], FACES[j]));
           }
       }
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
