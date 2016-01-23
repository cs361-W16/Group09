package models;

/**
 * Created by paullantow on 1/21/16.
 */
public class Board {
    public String[][] state = new String[13][4];
    public Integer c0, c1, c2, c3;

    //Shuffle function should add this.
    public Board() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = "0";
            }
        }
        c0 = -1; c1 = -1; c2 = -1; c3 =-1;
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

    public void modBoard (int x, int y, String z){
        state[x][y] = z;
    }

    public String getCardOnBoard (int x, int y) {
        return state[x][y];
    }

    public void dealFourBoard() {

    }


}
