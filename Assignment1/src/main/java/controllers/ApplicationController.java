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

import ninja.Result;
import ninja.Results;
import models.Board;

import com.google.inject.Singleton;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        Result result =  Results.html().template("views/AcesUp/AcesUp.flt.html");
        //result.render("paulTest", "4");
        return result;
    }

    public Result getState() {
        Board testBoard = new Board();
        testBoard.modBoard(3,3,"Jack of Studs");
        return Results.json().render(testBoard);
    }
}