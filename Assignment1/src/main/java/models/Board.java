package models;

/**
 * Created by paullantow on 1/21/16.
 */
public class Board {
    public String[][] state = new String[13][4];
    public Card[][] cardLayout = new Card[13][4];
    public Integer c0, c1, c2, c3;
    public Deck theDeck = new Deck();
    public Integer score;

    //Shuffle function should add this.
    public Board() {
        //Text array
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = "";
            }
        }
        //Card array
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardLayout[i][j] = new Card();
            }
        }
        theDeck.newDeck();
        c0 = -1; c1 = -1; c2 = -1; c3 = -1;
        score = 0;
    }

    //Converts the card array to a string array
    public void cardToString() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (cardLayout[i][j].printCard() == "0 of None") {
                    state[i][j] = " ";
                }
                else {
                    state[i][j] = cardLayout[i][j].printCard();
                }
            }
        }
    }

    //Columns keep track of the highest position of a card in that column

    public void incC0() {
        c0++;
    }

    public void incC1() {
        c1++;
    }

    public void incC2() {
        c2++;
    }

    public void incC3() {
        c3++;
    }

    public void decC0() {
        c0--;
    }

    public void decC1() {
        c1--;
    }

    public void decC2() {
        c2--;
    }

    public void decC3() {
        c3--;
    }

    public int getC(int x) {
        if (x == 0)
            return c0;
        if (x == 1)
            return c1;
        if (x == 2)
            return c2;
        if (x == 3)
            return c3;
        else
            return 0;
    }

    public void modBoard (int x, int y, String z){
        state[x][y] = z;
    }

    public void modLayout (int x, int y, Card z){
        cardLayout[x][y] = z;
        state[x][y] = z.printCard();
    }


    public String getCardOnBoard (int x, int y) {
        return state[x][y];
    }

    public void drawFour() {
        incC0();
        incC1();
        incC2();
        incC3();

        modCardLayout(c0,0);
        modCardLayout(c1,1);
        modCardLayout(c2,2);
        modCardLayout(c3,3);
    }

    public void modCardLayout(int r, int c) {
        cardLayout[r][c] = theDeck.drawTop();
    }

    public boolean isEmpty(int row){
        for(int x=0; x<=12; x++){
            if(state[x][row] != "0"){
                return false;
            }
        }
        return true;
    }

    //Swap from col 0
    public void swap0() {
        if (c1 == 0) {
            cardLayout[0][1] = cardLayout[getC(0)][0];
            cardLayout[getC(0)][0] = new Card();
            decC0();
            incC1();
        }
        else if (c2 == 0) {
            cardLayout[0][2] = cardLayout[getC(0)][0];
            cardLayout[getC(0)][0] = new Card();
            decC0();
            incC2();
        }
        else if (c3 == 0) {
            cardLayout[0][3] = cardLayout[getC(0)][0];
            cardLayout[getC(0)][0] = new Card();
            decC0();
            incC3();
        }
    }

    //Swap fom col 1
    public void swap1() {
        if (c0 == 0) {
            cardLayout[0][1] = cardLayout[getC(1)][1];
            cardLayout[getC(1)][1] = new Card();
            decC1();
            incC0();
        }
        else if (c2 == 0) {
            cardLayout[0][2] = cardLayout[getC(1)][1];
            cardLayout[getC(1)][1] = new Card();
            decC1();
            incC2();
        }
        else if (c3 == 0) {
            cardLayout[0][3] = cardLayout[getC(1)][1];
            cardLayout[getC(1)][1] = new Card();
            decC1();
            incC3();
        }
    }

    //Swap from col 2
    public void swap2() {
        if (c0 == 0) {
            cardLayout[0][0] = cardLayout[getC(2)][2];
            cardLayout[getC(2)][2] = new Card();
            decC2();
            incC0();
        }
        else if (c1 == 0) {
            cardLayout[0][1] = cardLayout[getC(2)][2];
            cardLayout[getC(2)][2] = new Card();
            decC2();
            incC1();
        }
        else if (c3 == 0) {
            cardLayout[0][3] = cardLayout[getC(2)][2];
            cardLayout[getC(2)][2] = new Card();
            decC2();
            incC3();
        }
    }

    //Swap from col 3
    public void swap3() {
        if (c0 == 0) {
            cardLayout[0][0] = cardLayout[getC(3)][3];
            cardLayout[getC(3)][3] = new Card();
            decC3();
            incC0();
        }
        else if (c1 == 0) {
            cardLayout[0][1] = cardLayout[getC(3)][3];
            cardLayout[getC(3)][3] = new Card();
            decC3();
            incC1();
        }
        else if (c2 == 0) {
            cardLayout[0][2] = cardLayout[getC(3)][3];
            cardLayout[getC(3)][3] = new Card();
            decC3();
            incC2();
        }
    }

    public void scoreCard() {
        //Check for matches in col 0
        if (cardLayout[c0][0].getSuit() == cardLayout[c1][1].getSuit() && cardLayout[c0][0].getValue() < cardLayout[c1][1].getValue()) {
            cardLayout[c0][0] = new Card();
            incScore();
            decC0();
        }
        else if (cardLayout[c0][0].getSuit() == cardLayout[c2][2].getSuit() && cardLayout[c0][0].getValue() < cardLayout[c2][2].getValue()) {
            cardLayout[c0][0] = new Card();
            incScore();
            decC0();
        }
        else if (cardLayout[c0][0].getSuit() == cardLayout[c3][3].getSuit() && cardLayout[c0][0].getValue() < cardLayout[c3][3].getValue()) {
            cardLayout[c0][0] = new Card();
            incScore();
            decC0();
        }

        //Check for matches in col 1
        if (cardLayout[c1][1].getSuit() == cardLayout[c0][0].getSuit() && cardLayout[c1][1].getValue() < cardLayout[c0][0].getValue()) {
            cardLayout[c1][1] = new Card();
            incScore();
            decC1();
        }
        else if (cardLayout[c1][1].getSuit() == cardLayout[c2][2].getSuit() && cardLayout[c1][1].getValue() < cardLayout[c2][2].getValue()) {
            cardLayout[c1][1] = new Card();
            incScore();
            decC1();
        }
        else if (cardLayout[c1][1].getSuit() == cardLayout[c3][3].getSuit() && cardLayout[c1][1].getValue() < cardLayout[c3][3].getValue()) {
            cardLayout[c1][1] = new Card();
            incScore();
            decC1();
        }

        //Check for matches in col 2
        if (cardLayout[c2][2].getSuit() == cardLayout[c0][0].getSuit() && cardLayout[c2][2].getValue() < cardLayout[c0][0].getValue()) {
            cardLayout[c2][2] = new Card();
            incScore();
            decC2();
        }
        else if (cardLayout[c2][2].getSuit() == cardLayout[c1][1].getSuit() && cardLayout[c2][2].getValue() < cardLayout[c1][1].getValue()) {
            cardLayout[c2][2] = new Card();
            incScore();
            decC2();
        }
        else if (cardLayout[c2][2].getSuit() == cardLayout[c3][3].getSuit() && cardLayout[c2][2].getValue() < cardLayout[c3][3].getValue()) {
            cardLayout[c2][2] = new Card();
            incScore();
            decC2();
        }

        //Check for matches in col 3
        if (cardLayout[c3][3].getSuit() == cardLayout[c0][0].getSuit() && cardLayout[c3][3].getValue() < cardLayout[c0][0].getValue()) {
            cardLayout[c3][3] = new Card();
            incScore();
            decC3();
        }
        else if (cardLayout[c3][3].getSuit() == cardLayout[c2][2].getSuit() && cardLayout[c3][3].getValue() < cardLayout[c2][2].getValue()) {
            cardLayout[c3][3] = new Card();
            incScore();
            decC3();
        }
        else if (cardLayout[c3][3].getSuit() == cardLayout[c3][1].getSuit() && cardLayout[c3][3].getValue() < cardLayout[c3][1].getValue()) {
            cardLayout[c3][3] = new Card();
            incScore();
            decC3();
        }

    }

    public Integer getScore() {
        return score;
    }

    private void incScore() {
        score++;
    }



}
