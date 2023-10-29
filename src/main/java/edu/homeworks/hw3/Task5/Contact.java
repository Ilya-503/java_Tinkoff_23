package edu.homeworks.hw3.Task5;

public record Contact(String firstName, String secondName) {

    @Override
    public String toString() {
        if (secondName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + secondName;
    }
}
