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
        c0 = 0; c1 = 0; c2 = 0; c3 =0;
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
