package edu.homeworks.hw3.Task5;

import edu.projects.project1.Utils;
import java.util.Arrays;
import java.util.Comparator;


public final class Task5 {

    private static final String LEGAL_NAME_REGEX = "^[a-zA-Z]+[ ]?[a-zA-Z]*$";

    private Task5() {
    }

    public static Contact[] parseContacts(String[] names, SortDirection direction) throws IllegalArgumentException {
        if (names == null) {
            return new Contact[0];
        }

        Contact[] contacts = new Contact[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            if (!Utils.isMatchingRegex(name, LEGAL_NAME_REGEX)) {
                throw new IllegalArgumentException("Illegal name format: " + name);
            }

            var nameInfo = name.split(" ");
            String firstName = nameInfo[0];
            String secondName = nameInfo.length == 2 ? nameInfo[1] : "";

            contacts[i] = new Contact(firstName, secondName);
        }

        var comparator = getComparator(direction);
        Arrays.sort(contacts, comparator);
        return contacts;
    }

    private static Comparator<Contact> getComparator(SortDirection direction) {

        var comparator = new Comparator<Contact>() {

            @Override
            public int compare(Contact o1, Contact o2) {

                String name1 = o1.secondName();
                if (name1.isEmpty()) {
                    name1 = o1.firstName();
                }

                String name2 = o2.secondName();
                if (name2.isEmpty()) {
                    name2 = o2.firstName();
                }

                name1 = name1.toLowerCase();
                name2 = name2.toLowerCase();

                return name1.compareTo(name2);
            }

            @Override
            public Comparator<Contact> reversed() {
                return Comparator.super.reversed();
            }
        };

        return switch (direction) {
            case ASC -> comparator;
            case DESC -> comparator.reversed();
        };
    }

}
