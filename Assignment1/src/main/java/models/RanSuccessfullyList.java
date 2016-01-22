package models;

import java.util.ArrayList;

/**
 * Created by michaelhilton on 1/5/16.
 */
public class RanSuccessfullyList {
    private ArrayList<Person> persons;

    public RanSuccessfullyList(){
        persons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person p) {
        persons.add(p);
    }
}
