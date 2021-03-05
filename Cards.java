public class Cards{
   private String suit;
   private String face;
   public final String[] FACES = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
   public final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

   public Cards(String suit, String face){
       this.suit = suit;
       this.face = face;
   }

   public void setSuit(String suit){
       this.suit = suit;
   }

   public String getSuit(){
       return suit;
   }

   public void setFace(String face){
       this.face = face;
   }

   public String getFace(){
       return face;
   }

   public String toString(){
       return face + " of " + suit;
   }

}
