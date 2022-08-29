package JavaOOP.HomeWork1;

import javafx.util.Pair;

import java.util.*;

public class GenTree {

    private Map<Link, List<Link>> invertedOnes = new HashMap<Link, List<Link>>() {{ // in constructor or not?
        put(Link.SON, new ArrayList<Link>() {{  // vs Arrays.asList()?
            add(Link.FATHER);
            add(Link.MOTHER);
        }});
        put(Link.DAUGHTER, new ArrayList<Link>() {{
            add(Link.FATHER);
            add(Link.MOTHER);
        }});
        put(Link.FATHER, new ArrayList<Link>() {{
            add(Link.SON);
            add(Link.DAUGHTER);
        }});
        put(Link.MOTHER, new ArrayList<Link>() {{
            add(Link.SON);
            add(Link.DAUGHTER);
        }});
        put(Link.HUSBAND, new ArrayList<Link>() {{
            add(Link.WIFE);
        }});
        put(Link.WIFE, new ArrayList<Link>() {{
            add(Link.HUSBAND);
        }});
    }};

    // graph of links in family tree
    private Map<Person, List<Pair<Person, Link>>> relatives = new HashMap<>();

    public Boolean addPerson(Person base, Person toAdd, Link link) throws Exception {

        if (base == null && toAdd != null && relatives.keySet().size() == 0) {
            relatives.put(toAdd, new ArrayList<>());
            return true;
        }

        if (toAdd == null || base == null) {
            throw new Exception("Cannot add a zero person");
        }

        for (Person p : relatives.keySet()) {
            if (p.equals(toAdd)) {
                throw new Exception("The identical person been already added to the graph");
            }
        }

        addLink(base, toAdd, link);

        addLink(toAdd, base, getInvertedLink(link, base));

        if (link == Link.DAUGHTER || link == Link.SON) {
            Person secondParent = getPersonByLink(base, base.getSex() == Sex.FEMALE ? Link.HUSBAND : Link.WIFE);
            addLink(secondParent, toAdd, link);
            addLink(toAdd, secondParent, getInvertedLink(link, secondParent));
        }

        return true;  // needed?)
    }

    private void addLink(Person base, Person toAdd, Link link) {

        if (relatives.containsKey(base)) {

            relatives.get(base).add(new Pair<>(toAdd, link));

        } else {

            relatives.put(base, new ArrayList<Pair<Person, Link>>(){{add(new Pair<>(toAdd, link));}});
        }
    }

    public boolean removePerson(Person person) throws Exception {

        if (!relatives.containsKey(person)) {
            throw new Exception("There is no such person in the family tree");
        }

        relatives.remove(person);

        for (Person key : relatives.keySet()) {
            ListIterator<Pair<Person, Link>> iterator = relatives.get(key).listIterator();

            while (iterator.hasNext()) {
                Pair<Person, Link> pair = iterator.next();
                if (pair.getKey() == person) {
                    iterator.remove();
                }
            }
        }

        return true; // needed?)
    }

    public Link getInvertedLink(Link link, Person p) {
        List<Link> invertedLinks = invertedOnes.get(link);
        if (invertedLinks.size() == 1) {
            return invertedLinks.get(0);
        } else {
            if (p.getSex() == Sex.MALE) {
                return invertedLinks.get(0);
            } else {
                return invertedLinks.get(1);
            }
        }
    }

    private Person getPersonByLink(Person base, Link link) { // what if more than 1 person been found? -> further updates
        for (Pair<Person, Link> pair : relatives.get(base)) {
            if (pair.getValue() == link) {
                return pair.getKey();
            }
        }

        return null;
    }

    public void showRelatives(Person person) throws Exception {

        if (!relatives.containsKey(person)) {
            throw new Exception("There is no such person in the family tree");
        }

        StringBuilder b = new StringBuilder(person + ": [");
        for (Pair<Person, Link> p: relatives.get(person)) {
            b.append(p.getKey()).append(": ").append(p.getValue()).append(", ");
        }
        b.replace(b.length() - 2, b.length(), "");
        System.out.println(b + "]");
    }

    public void showGraph() {
        int counter = 0;

        StringBuilder b;

        for (Person key : relatives.keySet()) {
            b = new StringBuilder("");
            b.append(++counter).append(". ").append(key).append(" : [");
            for (Pair<Person, Link> pair: relatives.get(key)) {
                 b.append(pair.getKey()).append(": ").append(pair.getValue()).append(", ");
            }
            b.replace(b.length() - 2, b.length(), "");
            System.out.println(b + "]");
        }
    }
}

// class for describing persons
class Person {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    private final String firstName;  // name
    private final String lastName;  // surname

    private final String fathersName; // otchestvo

    private final int year; // birthday year

    private final Sex sex;

    public Person(String fName, String lName, String o, Sex s, int y) {
        firstName = fName;
        lastName = lName;
        fathersName = o;
        sex = s;
        year = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) &&
                fathersName.equals(person.lastName) && sex == person.sex && year == person.year;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + fathersName;
    }
}

enum Link {  // can be extended -> but it requires more subtle and complicated logic in addPerson() method
    FATHER,
    MOTHER,
    SON,
    DAUGHTER,
    HUSBAND,
    WIFE
}

enum Sex {  // just two for simplicity
    MALE,
    FEMALE
}

//class AnException extends Exception {
//    public AnException() { super(); }
//    public AnException(String message) { super(message); }
//    public AnException(String message, Throwable cause) { super(message, cause); }
//    public AnException(Throwable cause) { super(cause); }
//}

