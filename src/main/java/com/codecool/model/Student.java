package com.codecool.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private int cleanOrder;

    public Student(String firstName, String lastName, int age, int cleanOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cleanOrder = cleanOrder;
    }

    public int getCleanOrder() {
        return cleanOrder;
    }

    public void setCleanOrder(int cleanOrder) {
        this.cleanOrder = cleanOrder;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", cleanOrder=" + cleanOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && cleanOrder == student.cleanOrder && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, cleanOrder);
    }
}
