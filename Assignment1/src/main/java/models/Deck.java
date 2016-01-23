package models;

/**
 * Created by Dilon_000 on 1/21/2016.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Deck {

    public ArrayList<Card> deck;

    public Deck() { deck = new ArrayList<>(); }

    public void newDeck(){
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
        deck = new ArrayList<Card>(Arrays.asList(d));
        Collections.shuffle(deck);
    }


    public Card drawTop() {
        Card t = deck.get(0);
        deck.remove(0);
        return t;
    }


}
