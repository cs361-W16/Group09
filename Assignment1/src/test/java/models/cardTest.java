package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilon_000 on 1/21/2016.
 */
public class cardTest {

    @Test
    public void cardValueTest1(){
        card c1 = new card();

        assertEquals(0, c1.getValue());
    }

    @Test
    public void cardValueTest2(){
        card c2 = new card(1);

        assertEquals(1, c2.getValue());
    }

    @Test
    public void cardSuitTest1(){
        card c3 = new card();

        assertEquals("None", c3.getSuit());
    }

    @Test
    public void cardSuitTest2(){
        card c4 = new card("Hearts");

        assertEquals("Hearts", c4.getSuit());
    }

    @Test
    public void cardValueSuitTest(){
        card c5 = new card(1, "Hearts");

        assertEquals(1, c5.getValue());
        assertEquals("Hearts", c5.getSuit());
    }

    @Test
    public void cardPrintTest1(){
        card c6 = new card(2, "Hearts");

        assertEquals("2 of Hearts", c6.printCard());
    }

    @Test
    public void cardPrintTest2(){
        card c7 = new card(11, "Hearts");

        assertEquals("Jack of Hearts", c7.printCard());
    }

    @Test
    public void cardPrintTest3(){
        card c8 = new card(12, "Hearts");

        assertEquals("Queen of Hearts", c8.printCard());
    }

    @Test
    public void cardPrintTest4(){
        card c9 = new card(13, "Hearts");

        assertEquals("King of Hearts", c9.printCard());
    }

    @Test
    public void cardPrintTest5(){
        card c10 = new card(14, "Hearts");

        assertEquals("Ace of Hearts", c10.printCard());
    }

}