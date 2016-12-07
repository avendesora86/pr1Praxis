package pr1.a07;

import pr1.a06.Person;

import java.util.Comparator;

/**
 * Created by shari on 06.12.2016.
 */
public class NameComparator implements Comparator<Person> {

    public int compare(Person p1, Person p2) {
        return p1.getNachname().compareTo(p2.getNachname());
    }
}
