package models;

/**
 * Created by paullantow on 1/21/16.
 */
public class Board {
    public String[][] Board = new String[13][4];

    //Shuffle function should add this.
    public initBoard() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Board[i][j] = "0";
            }
        }
    }

    public void modBoard (int x, int y, String z){
        Board[x][y] = z;
    }

    public String getCard (int x, int y) {
        return Board[x][y];
    }
}