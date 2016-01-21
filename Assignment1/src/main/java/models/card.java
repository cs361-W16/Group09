package models;

/**
 * Created by Dilon_000 on 1/21/2016.
 */
public class card {

    private int value;
    private String suit;

    public card(){
        value = 0;
        suit = "None";
    }

    public card(int v){
        value = v;
    }

    public card(String s){
        suit = s;
    }

    public card(int v, String s){
        value = v;
        suit = s;
    }

    public int getValue(){
        return value;
    }

    public String getSuit(){
        return suit;
    }

    public String printCard(){
        if(value == 11){
            System.out.printf("Jack of %s\n", suit);

            return "Jack of " + suit;
        }
        else if(value == 12){
            System.out.printf("Queen of %s\n", suit);

            return "Queen of " + suit;
        }
        else if(value == 13){
            System.out.printf("King of %s\n", suit);

            return "King of " + suit;
        }
        else if(value == 14){
            System.out.printf("Ace of %s\n", suit);

            return "Ace of " + suit;
        }
        else {
            System.out.printf("%d of %s\n", value, suit);

            return value + " of " + suit;
        }
    }
}
