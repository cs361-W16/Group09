package models;

/**
 * Created by TheTallPaul on 1/20/16.
 */

public class Scoring {
    public Integer score;

    public Scoring() {
        score = 0;
    }

    public void scoreCard(Board layout) {
        //Run through the columns
        for (int i = 0; i < 3; i++) {
            //Run through the rows
            for (int j = 0; j < 12; j++) {
                //Check for suit and that the top is greater by 1
                if (layout.cardLayout[j][i].getSuit() == layout.cardLayout[j+1][i].getSuit() && layout.cardLayout[j][i].getValue() == layout.cardLayout[j+1][i].getValue()+1 ){
                    //Remove card
                    layout.cardLayout[j+1][i] = new Card();
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