package JavaOOP.HomeWork1;

import javafx.util.Pair;

public interface AbleToDoResearch {
    default void showRelatives(GenTree tree, Person person) throws Exception {

        if (!tree.getRelatives().containsKey(person)) {
            throw new Exception("There is no such person in the family tree");
        }

        StringBuilder b = new StringBuilder(person + ": [");
        for (Pair<Person, Link> p: tree.getRelatives().get(person)) {
            b.append(p.getKey()).append(": ").append(p.getValue()).append(", ");
        }
        b.replace(b.length() - 2, b.length(), "");
        System.out.println(b + "]");
    }

    default void showGraph(GenTree tree) {
        int counter = 0;

        StringBuilder b;

        for (Person key : tree.getRelatives().keySet()) {
            b = new StringBuilder("");
            b.append(++counter).append(". ").append(key).append(" : [");
            for (Pair<Person, Link> pair: tree.getRelatives().get(key)) {
                 b.append(pair.getKey()).append(": ").append(pair.getValue()).append(", ");
            }
            b.replace(b.length() - 2, b.length(), "");
            System.out.println(b + "]");
        }
    }
}
