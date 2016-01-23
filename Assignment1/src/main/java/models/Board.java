package models;

/**
 * Created by paullantow on 1/21/16.
 */
public class Board {
    public String[][] state = new String[13][4];
    public Card[][] cardLayout = new Card[13][4];
    public Integer c0, c1, c2, c3;

    //Shuffle function should add this.
    public Board() {
        //Text array
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = "0";
            }
        }
        //Card array
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardLayout[i][j] = new Card();
            }
        }
        c0 = -1; c1 = -1; c2 = -1; c3 =-1;
    }

    //Converts the card array to a string array
    public void cardToString() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = cardLayout[i][j].printCard();
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

    public void modLayout (int x, int y, Card z){
        cardLayout[x][y] = z;
        state[x][y] = z.printCard();
    }

    public boolean isEmpty(int row){
        for(int x=0; x<=12; x++){
            if(state[x][row] != "0"){
                return false;
            }
        }
        //System.out.printf("empty");
        return true;
    }

    public Card getCard(int x, int y) { return cardLayout[x][y]; }

    public String getCardOnBoard (int x, int y) {
        return state[x][y];
    }

    public void dealFourBoard() {

    }


}
