package models;

/**
 * Created by touku_000 on 1/21/2016.
 */

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class DrawFour {

    public int cardDeck = 52;

    public int Draw(int drawed){
        if(cardDeck != 0) {
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
