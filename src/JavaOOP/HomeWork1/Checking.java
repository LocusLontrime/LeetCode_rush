package JavaOOP.HomeWork1;

public class Checking {

    public static void main(String[] args) throws Exception {

        Person levi = new Person("Евгений", "Черкасов", "Эдуардович", Sex.MALE, 1997);
        Person kate = new Person("Екатерина", "Черкасова", "Сергеевна", Sex.FEMALE, 1997);

        Person locus = new Person("Дмитрий", "Прудников", "Анатольевич", Sex.MALE, 1992);
        Person elena = new Person("Елена", "Гречка", "Сергеевна", Sex.FEMALE, 1997);

        Person roman = new Person("Роман", "Черкасов", "Евгеньевич", Sex.MALE, 2018);
        Person vica = new Person("Виктория", "Прудникова", "Дмитриевна", Sex.FEMALE, 2017);

        Person sophia = new Person("София", "Путина", "Романовна", Sex.FEMALE, 2019);

        GenTree tree = new GenTree();

        tree.addPerson(null, levi, null);

        tree.addPerson(levi, kate, Link.WIFE);

        tree.addPerson(kate, roman, Link.SON);

        tree.addPerson(levi, vica, Link.DAUGHTER);

        // tree.addPerson(null, null, null); -> tests

        tree.showGraph();
    }

}
