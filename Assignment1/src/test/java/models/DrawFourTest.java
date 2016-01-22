package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by touku_000 on 1/21/2016.
 * Test cases for DrawFour Class.
 */
 
 
public class DrawFourTest {

	@Test
	public void Draw0() {
		DrawFour d0 = new DrawFour();
		assertEquals(52, d0.Draw(52));
	}
   
}
