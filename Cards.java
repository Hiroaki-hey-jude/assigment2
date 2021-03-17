import java.util.Locale;

public class Cards{
    private String suit;
    private String face;
    public final String[] FACES = {"A","2","3","4","5","6","7","8","9", "X", "J","Q","K"};
    public final String[] SUITS = {"c", "d", "h", "s"};
    //                         clubs diamonds hearts spades

    public Cards(String suit, String face){
        this.suit = suit;
        this.face = face;
    }

    public Cards(){}

    public void setSuit(String suit){
        this.suit = suit;
    }

    public String getSuit(){
        return suit;
    }
    public int getSuitValue() {
        switch(face.toLowerCase())
        {
            case "a":
                return 1;
            case "x":
                return 10;
            case "j":
                return 11;
            case "q":
                return 12;
            case "k":
                return 13;
            default:
                return Integer.parseInt(face);
        }
    }

    public void setFace(String face){
        this.face = face;
    }

    public String getFace(){
        return face;
    }

    public String toString(){
        return suit + face;
    }

}


