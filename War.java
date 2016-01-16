/*
 * Original Author: davisdy
 * File: War.java
 * Date Created: March 10, 2012 at 3:30p.m.
 * Last Modified: March 16, 2012 at 6:30p.m.
 *
 * This file contains a program that simulates the card game war
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class War{
	
	/*
	 * Checks to see if either players decks is empty in the middle of a war.
	 * If one is, the other player automatically wins
	 */
	public static void outOfCards(ArrayList<Card> p1, ArrayList<Card> p2){
		if(p1.size() == 0){
			System.out.printf("Player 1 does not have enough cards\n");
			System.out.printf("to finish the war\n");
			System.out.printf("\n");
			System.out.printf("Player 2 wins\n");
			System.out.printf("Game Over\n");
			System.exit(0);
		}
		else if(p2.size() == 0){
            System.out.printf("Player 2 does not have enough cards\n");
            System.out.printf("to finish the war\n");
			System.out.printf("\n");
			System.out.printf("Player 1 wins\n");
			System.out.printf("Game Over\n");
			System.exit(0);
		}		
		return;
	}

	/*
	 * Shuffles the array of 52 set playing cards
	 */
	public static void shuffleDeck(Card[] d){
        List<Card> deckList = Arrays.asList(d);
        Collections.shuffle(deckList);
        d = deckList.toArray(d);	 
	}

	/*
	 * Takes an array of 52 uninstanciated cards and assigns each one a 
	 * value and suit
	 */
	public static void newDeck(Card[] n){
		if(n.length != 52){
			System.out.printf("Error: Deck must have 52 cards\n");
			System.exit(0);
		}
        String suit[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        int qrtdeck = 0;
        for(int i = 0; i <= 3; ++i){
            String s = suit[i];
            for(int j = 0; j <= 12; ++j){
                n[j + qrtdeck] = new Card(j + 2, s);
            }
            qrtdeck = qrtdeck + 13;
        }
	}

	/*
	 * Takes two arrays of 26 uninstanciated cards that represent the two 
	 * players as well as an array of 52 instanciated and shuffled cards
	 * and sets each player card equal to one of the 52 cards to 
	 * represent dealing
	 */
	public static void deal(Card[] d, Card[] p1, Card[] p2){
		if(p1.length != 26 || p2.length != 26 || d.length != 52){
			System.out.printf("Error: Must give 26 cards to each player\n");
			System.exit(0);
		}
		for(int i = 0; i <= 25; ++i){    
			p1[i] = d[i * 2];
			p2[i] = d[(i * 2) + 1];
		}
	}

	/*
	 * Simulates the actions taken when players play cards of equal values, 
	 * a war. Will continue until two unequal cards are played. If either
	 * player runs out of cards during a war, the other player automatically
	 * wins. outOfCards method is called after each played card to 
	 * simulate this
	 */
	public static void warTurn(ArrayList<Card> p1, ArrayList<Card> p2){
		int i = 0;
		ArrayList<Card> onTable = new ArrayList<Card>(); 
		do{			
			System.out.printf("War!\n");							   
			onTable.add(i, (Card)p1.get(0));
			onTable.add((i + 1), (Card)p2.get(0));
			p1.remove(0);
			p2.remove(0);
			outOfCards(p1, p2);
			System.out.printf("Players each play one face down card\n"); 
			onTable.add((i + 2), (Card)p1.get(0));
			onTable.add((i + 3), (Card)p2.get(0));
			p1.remove(0);
			p2.remove(0);
			outOfCards(p1, p2);
			System.out.printf("Then Player 1 plays a ");
			p1.get(0).printCard();
			System.out.printf("and Player 2 plays a ");
			p2.get(0).printCard();			
			i = i + 4;
		}
		while(p1.get(0).getValue() == p2.get(0).getValue());
		onTable.add(i, (Card)p1.get(0));
		onTable.add((i + 1), (Card)p2.get(0));
		if(p1.get(0).getValue() > p2.get(0).getValue()){
			System.out.printf("Player 1 wins this war\n");
			System.out.printf("and gets all the played cards\n");
			p1.remove(0);
			p2.remove(0);
			for(int j = 0; j <= (i + 1); ++j){
				p1.add(p1.size(), (Card)onTable.get(j));
			}
		}
		else if(p1.get(0).getValue() < p2.get(0).getValue()){
            System.out.printf("Player 2 wins this war\n");
            System.out.printf("and gets all the played cards\n");			
            p1.remove(0);
            p2.remove(0);
            for(int j = 0; j <= (i + 1); ++j){
                p2.add(p2.size(), (Card)onTable.get(j));
			}
		}
	}

	/*
	 * Simulates one turn of play in the game war. Removes top card from
	 * each players deck, which array ArrayLists, and adds them to the bottom
	 * of the player with the highest value card's deck. In the case of 
	 * equal card values, the warTurn method is called.
	 */
	public static void playTurn(int a, ArrayList<Card> p1, ArrayList<Card> p2){
		System.out.printf("Turn %d\n", a);
		System.out.printf("Player 1 plays a ");
		p1.get(0).printCard();		  
		System.out.printf("Player 2 plays a ");
		p2.get(0).printCard();                		 
		if(p1.get(0).getValue() > p2.get(0).getValue()){
			System.out.printf("Player 1 gets the cards\n");
			ArrayList<Card> onTable = new ArrayList<Card>();
			onTable.add(0, (Card)p1.get(0));
			onTable.add(1, (Card)p2.get(0));
			p1.remove(0);
			p2.remove(0);	
			p1.add(p1.size(), (Card)onTable.get(0));			
			p1.add(p1.size(), (Card)onTable.get(1));			
		}
		else if(p1.get(0).getValue() < p2.get(0).getValue()){
			System.out.printf("Player 2 gets the cards\n");
            ArrayList<Card> onTable = new ArrayList<Card>();
            onTable.add(0, (Card)p1.get(0));
            onTable.add(1, (Card)p2.get(0));
            p1.remove(0);
            p2.remove(0);						
            p2.add(p2.size(), (Card)onTable.get(0));			
            p2.add(p2.size(), (Card)onTable.get(1));			
		}
		else if(p1.get(0).getValue() == p2.get(0).getValue()){
			warTurn(p1, p2);
		}
		
		//Displays card count for each player on right of screen 
		System.out.printf("\t\t\t\t\t");
		System.out.printf("Player 1 has %d cards left\n", p1.size());
		System.out.printf("\t\t\t\t\t");
		System.out.printf("Player 2 has %d cards left\n", p2.size());
		System.out.printf("\n");
	}

	public static void main(String args[]){
		Card deck[] = new Card[52]; //Full, uninstanciated deck
		Card player1[] = new Card[26]; //Player 1 deck
		Card player2[] = new Card[26]; //Player 2 deck

		newDeck(deck);	 
		
		shuffleDeck(deck);
		
		deal(deck, player1, player2);

		/*
		 * Players' decks must be turned into ArrayLists so they can have 
		 * cards added and removed easily during play
		 */
		ArrayList<Card> player1List = 
			new ArrayList<Card>(Arrays.asList(player1));
		ArrayList<Card> player2List = 
			new ArrayList<Card>(Arrays.asList(player2));
		System.out.printf("Welcome to War\n");

		/*
		 * Loops the playTurn method call until one of the players has 
		 * no more cards in their deck, at which point the other player
		 * wins. Then the winner is displayed
		 */
		int t = 1;
		while(player1List.size() != 0 && player2List.size() != 0){
			playTurn(t, player1List, player2List);
			t = t + 1;
		}		
		if(player1List.size() == 0){
			System.out.printf("Player 2 wins\n");
			System.out.printf("Game Over\n");
			System.exit(0);
		}
		else if(player2List.size() == 0){
            System.out.printf("Player 1 wins\n");
            System.out.printf("Game Over\n");
            System.exit(0);
		}
	}
}
