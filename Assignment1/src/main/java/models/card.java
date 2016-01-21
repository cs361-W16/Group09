package models;/*
 * Original Author: davisdy
 * File: models.Card.java
 * Date Created: March 10, 2012 at 3:00p.m.
 * Last Modified: March 10, 2012 at 3:00p.m.
 *
 * This file contains a class to simulate playing cards for programs
 * of card games
 */

import java.util.Scanner;

public class Card{

    private int value; //2 through 14 to represent 2 through Ace
    private String suit;

    public Card(){
        this.value = 0;
        this.suit = "None";
    }
    public Card(int a, String b){
        this.value = a;
        this.suit = b;
    }
    public int getValue(){
        return value;
    }

    /*
     * Prints the suit and value of the card in the way it would be read
     * in a true card game. Values 11 through 14 print the names of
     * the face cards and ace respectively
     */
    public void printCard(){
        if(value == 14){
            System.out.printf("Ace of %s\n", suit);
        }
        else if(value == 13){
            System.out.printf("King of %s\n", suit);
        }
        else if(value == 12){
            System.out.printf("Queen of %s\n", suit);
        }
        else if(value == 11){
            System.out.printf("Jack of %s\n", suit);
        }
        else{
            System.out.printf("%d of %s\n", value, suit);
        }
    }
}