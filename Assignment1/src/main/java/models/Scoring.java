package models;

/**
 * Created by TheTallPaul on 1/20/16.
 */

public class Scoring {
    public Scoring() {
        //Run through the columns
        for (int i = 0; i < 3; i++) {
            //Run through the rows
            for (int j = 0; j < 12; j++) {
                String top = getCard(i,j);
                String bottom = getCard(i,j+1);
                //Check for suit and that the top is greater by 1
                if (top[2] == bottom[2] && Integer.parseInt(top.substring(0,1)) == Integer.parseInt(bottom.substring(0,1))+1) {

                }
            }
        }
    }
}
