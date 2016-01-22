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
import models.Person;
import models.RanSuccessfullyList;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.session.Session;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }

    private String a = "ddd";

    public Result init(Session session) {
        session.clear();
        Card card = new Card(14,"hearts");
        session.put("card","Ace of hearts");
        return Results.html().template("views/AcesUp/control.flt.html");
    }

    public Result control(Session session) {
        //String card = session.get("card");
        //return Results.html().render(card);
        session.put("num",a);
        return Results.html().template("views/AcesUp/control.flt.html");
    }

    public Result ranSuccessfully() {

        RanSuccessfullyList rsf = new RanSuccessfullyList();
        //This is a sample. You can copy and modify it for your needs.
        rsf.addPerson(new Person("Michael Hilton","MichaelHilton","Mac"));
        rsf.addPerson(new Person("Taylor Kirkpatrick","kirkpatt","Windows"));
        rsf.addPerson(new Person("Cody Holliday","hollidac","Windows"));
        rsf.addPerson(new Person("Wenbo Hou", "HouPoc", "Windows"));
        rsf.addPerson(new Person("Vasile Grejuc", "grejucv", "Mac"));
        rsf.addPerson(new Person("Xiaoyong Zheng","zhengxiaoyong","Windows"));
        rsf.addPerson(new Person("Aileen Thai", "athai", "Linux"));
        rsf.addPerson(new Person("Daniel Goh", "danielgwj", "Mac"));

        return Results.json().render(rsf);

    }

}
