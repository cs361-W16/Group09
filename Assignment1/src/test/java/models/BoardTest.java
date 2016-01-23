package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paullantow on 1/22/16.
 */
public class BoardTest {
    Board testableBoard = new Board();

    @Test
    public void testIncC0() throws Exception {

    }

    @Test
    public void testIncC1() throws Exception {

    }

    @Test
    public void testIncC2() throws Exception {

    }

    @Test
    public void testIncC3() throws Exception {

    }

    @Test
    public void testDecC0() throws Exception {

    }

    @Test
    public void testDecC1() throws Exception {

    }

    @Test
    public void testDecC2() throws Exception {

    }

    @Test
    public void testDecC3() throws Exception {

    }

    @Test
    public void testModBoard() throws Exception {

    }

    @Test
    public void testGetCardOnBoard() throws Exception {
        assertEquals("The first one should be 0",0,testableBoard.getCardOnBoard(0,0));

    }

    @Test
    public void testDealFourBoard() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals("Row 3 should be empty",true,testableBoard.isEmpty(3));
    }
    
    @Test
    public void testModLayout() throws Exception {
    }
}