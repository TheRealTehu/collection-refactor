package com.codecool.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Table {
    private final Student[] students;
    private final Chair[] chairs;
    private int numberOfStudents;
    public Table() {
        students = new Student[4];
        chairs = new Chair[4];
    }

    public void addStudent(Student student, Chair chair) {
        if(numberOfStudents < students.length && numberOfStudents < chairs.length) {
            students[numberOfStudents] = student;
            chairs[numberOfStudents] = chair;
            numberOfStudents++;
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public Optional<Student> getStudentForChairById(int chairId) {
        for(int i = 0; i < chairs.length; i++) {
            if(chairs[i] != null && chairs[i].getId() == chairId) {
                return Optional.of(students[i]);
            }
        }
        return Optional.empty();
    }

    public Student getOldestStudent() {
        Student oldestStudent = null;
        for(Student student : students) {
            if(student != null) {
                if (oldestStudent == null || student.getAge() > oldestStudent.getAge()) {
                    oldestStudent = student;
                }
            }
        }
        return oldestStudent;
    }

    @Override
    public String toString() {
        return "Table{" +
                "students=" + Arrays.toString(students) +
                ", chairs=" + Arrays.toString(chairs) +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return numberOfStudents == table.numberOfStudents && Arrays.equals(students, table.students) && Arrays.equals(chairs, table.chairs);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfStudents);
        result = 31 * result + Arrays.hashCode(students);
        result = 31 * result + Arrays.hashCode(chairs);
        return result;
    }
}
