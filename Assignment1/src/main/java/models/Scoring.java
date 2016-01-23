package models;

/**
 * Created by TheTallPaul on 1/20/16.
 */

public class Scoring {
    public Integer score;

    public Scoring() {
        score = 0;
    }

    public void scoreCard(Board state) {
        //Run through the columns
        for (int i = 0; i < 3; i++) {
            //Run through the rows
            for (int j = 0; j < 12; j++) {
                String top = state.getCardOnBoard(j,i);
                String bottom = state.getCardOnBoard(j+1,i);
                //Check for suit and that the top is greater by 1
                if (top.charAt(2) == bottom.charAt(2) && Integer.parseInt(top.substring(0,1)) == Integer.parseInt(bottom.substring(0,1))+1) {
                    //Remove card
                    state.modLayout(j+1,i,new Card());
                    //Increment score
                    incScore();
                }
            }
        }
    }

    public Integer getScore() {
        return score;
    }

    private void incScore() {
        score++;
    }
}