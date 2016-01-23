package models;

/**
 * Created by Dilon_000 on 1/21/2016.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Deck {

    /*public Card[] newDeck(){
        Card d[] = new Card[52];
        if(d.length != 52){
            System.out.printf("Error: Deck must have 52 cards\n");
            System.exit(0);
        }
        String suit[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        int qrtdeck = 0;
        for(int i = 0; i <= 3; ++i){
            String s = suit[i];
            for(int j = 0; j <= 12; ++j){
                d[j + qrtdeck] = new Card(j + 2, s);
            }
            qrtdeck = qrtdeck + 13;
        }
        return d;
    }

    public static void shuffleDeck(Card[] s){
        List<Card> deckList = Arrays.asList(s);
        Collections.shuffle(deckList);
        s = deckList.toArray(s);
    }*/

    private ArrayList<Card> deck;

    public Deck() { deck = new ArrayList<>(); }

    public ArrayList<Card> getCards() { return deck; }

    public void setCards(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void addCard(Card p) {
        deck.add(p);
    }

    public void remove() { deck.remove(0); }

}
