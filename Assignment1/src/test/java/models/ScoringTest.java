package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paullantow on 1/22/16.
 */
public class ScoringTest {

    Scoring scoreTest = new Scoring();

    @Test
    public void testScoring() throws Exception {

    }

    @Test
    public void testGetScore() throws Exception {
        assertEquals("Initial score is 0","0",scoreTest.getScore());
    }
}