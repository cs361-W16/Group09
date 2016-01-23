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
import models.Scoring;

import com.google.inject.Singleton;


@Singleton
public class ApplicationController {
    public Board testBoard = new Board();
    public Scoring theScore = new Scoring();

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        Result result =  Results.html().template("views/AcesUp/AcesUp.flt.html");
        return result;
    }

    public Result getState() {
        testBoard = new Board();

        testBoard.cardToString();
        return Results.json().render(testBoard);
    }


    public Result deal() {
        testBoard.drawFour();
        testBoard.cardToString();

        return Results.json().render(testBoard);
    }

    public Result score() {
        testBoard.scoreCard();
        testBoard.cardToString();

        return Results.json().render(testBoard);
    }

    /*public Result init() {
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
