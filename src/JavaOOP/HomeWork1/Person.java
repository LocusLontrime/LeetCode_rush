package JavaOOP.HomeWork1;

// class for describing persons
class Person implements Comparable<Person> {

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

    public int getYear() {
        return year;
    }

    public String getFathersName() {
        return fathersName;
    }

    @Override
    public int compareTo(Person p) {  // in case of our project and needs
        if (!getFirstName().equals(p.getFirstName())) {
            return getFirstName().compareTo(p.getFirstName());
        } else {
            if (!getLastName().equals(p.getLastName())) {
                return getLastName().compareTo(p.getLastName());
            } else {
                if (!getFathersName().equals(p.getFathersName())) {
                    return getFathersName().compareTo(p.getFathersName());
                } else {
                    if (!getSex().equals(p.getSex())) {
                        return getSex().compareTo(p.getSex());
                    } else {
                        if(getYear() != p.getYear()) {
                            return p.getYear() - getYear();
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {  // in general
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