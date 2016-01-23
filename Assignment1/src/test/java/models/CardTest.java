package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilon_000 on 1/21/2016.
 */
public class CardTest {

    @Test
    public void cardValueTest1(){
        Card c1 = new Card();

        assertEquals(0, c1.getValue());
    }

    @Test
    public void cardValueTest2(){
        Card c2 = new Card(1);

        assertEquals(1, c2.getValue());
    }

    @Test
    public void cardSuitTest1(){
        Card c3 = new Card();

        assertEquals("None", c3.getSuit());
    }

    @Test
    public void cardSuitTest2(){
        Card c4 = new Card("Hearts");

        assertEquals("Hearts", c4.getSuit());
    }

    @Test
    public void cardValueSuitTest(){
        Card c5 = new Card(1, "Hearts");

        assertEquals(1, c5.getValue());
        assertEquals("Hearts", c5.getSuit());
    }

    @Test
    public void cardPrintTest1(){
        Card c6 = new Card(2, "Hearts");

        assertEquals("2 of Hearts", c6.printCard());
    }

    @Test
    public void cardPrintTest2(){
        Card c7 = new Card(11, "Hearts");

        assertEquals("Jack of Hearts", c7.printCard());
    }

    @Test
    public void cardPrintTest3(){
        Card c8 = new Card(12, "Hearts");

        assertEquals("Queen of Hearts", c8.printCard());
    }

    @Test
    public void cardPrintTest4(){
        Card c9 = new Card(13, "Hearts");

        assertEquals("King of Hearts", c9.printCard());
    }

    @Test
    public void cardPrintTest5(){
        Card c10 = new Card(14, "Hearts");

        assertEquals("Ace of Hearts", c10.printCard());
    }

}
