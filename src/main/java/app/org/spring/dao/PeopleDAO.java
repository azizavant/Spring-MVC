package app.org.spring.dao;

import app.org.spring.models.Person;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private final List<Person> people =  new ArrayList<>();
    private static int ID;

    {
        people.add(new Person(++ID, "Aziz"));
        people.add(new Person(++ID, "Abzal"));
        people.add(new Person(++ID, "Erni"));
        people.add(new Person(++ID, "Aldik"));
        people.add(new Person(++ID, "Shoqan"));
        people.add(new Person(++ID, "Sultan"));
    }

    public List<Person> index() {
        return people;
    }

    public Person getPerson(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void create(Person person) {
        person.setId(++ID);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = getPerson(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }
}
