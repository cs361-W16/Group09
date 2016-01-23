/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Card;
import models.Deck;
import ninja.Result;
import ninja.Results;
import models.Board;

import com.google.inject.Singleton;
import ninja.params.Param;


@Singleton
public class ApplicationController {
    public Board testBoard = new Board();
    public Deck theDeck = new Deck();

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        Result result =  Results.html().template("views/AcesUp/AcesUp.flt.html");
        //result.render("paulTest", "4");
        return result;
    }

    public Result getState() {
        return Results.json().render(testBoard);
    }


    public Result deal() {
        //testBoard.dealFourBoard();
        testBoard.modLayout(3,2,new Card(7,"diamonds"));
        return Results.json().render(testBoard);
    }

    public  Result newBoard() {
        testBoard = new Board();
        return Results.json().render(testBoard);
    }

    public Result swap(@Param("row") int row){

        int lastCard = 99;
        testBoard.isEmpty(1);
        for(int x=0; x<13; x++){
            if(testBoard.getCard(x,row).getValue() != 0){
                lastCard = x;
            }
        }

        if (lastCard != 99) {
            int newRow = 0;
            for (newRow = 0; newRow <= 3; newRow++) {
                if (testBoard.isEmpty(newRow)) {
                    testBoard.modLayout(0, newRow, testBoard.getCard(lastCard, row));
                    testBoard.modLayout(lastCard, row, new Card());
                    break;
                }
            }
        }

        return Results.json().render(testBoard);
    }



    /*
    public Result init() {
        Deck deck = new Deck();
        for(int x=2; x<=14; x++) {
            deck.addCard(new Card(x, "hearts"));
        }

        return Results.json().render(deck);
    }

    public Result remove(Deck deck) {
        deck.remove();

        return Results.json().render(deck);
    }*/

}