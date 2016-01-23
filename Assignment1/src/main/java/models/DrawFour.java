package models;

/**
 * Created by touku_000 on 1/21/2016.
 */

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class DrawFour {

    private int cardDeck = 52;

    public int Draw(int drawed){
        if(cardDeck != 0) {

            //initial array, oldArray should be replaced by the Deck array
            int[] oldArray = {1,2,3,4,5};

            //define a new array + allocate space for four cards
            int[] drawArray = new int[4];

            //copy values
            System.arraycopy(oldArray, 0, drawArray, 0, oldArray.length);

            cardDeck -= 4;
            //test print
            System.out.println("You drew four card and have:" + cardDeck + " cards left in the deck");
        }
        else {
            System.out.println("You have no more cards to deal!");
        }
        return(drawed);
    }

}
