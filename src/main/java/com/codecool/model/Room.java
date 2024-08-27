package com.codecool.model;

import java.util.Optional;

public class Room {
    private final Table[] tables;
    private int numberOfTables;
    private final Student[] cleaningOrder;

    public Room() {
        tables = new Table[10];
        cleaningOrder = new Student[40];
    }

    public boolean addTable(Table table) {
        if (numberOfTables < tables.length && !containsTable(table)) {
            addStudentsToCleaningOrder(table);
            tables[numberOfTables] = table;
            numberOfTables++;
            return true;
        }
        return false;
    }

    private boolean containsTable(Table table) {
        for (Table tableInRoom : tables) {
            if (table.equals(tableInRoom)) {
                return true;
            }
        }
        return false;
    }

    private void addStudentsToCleaningOrder(Table table) {
        for (Student student : table.getStudents()) {
            if(student != null) {
                int index = findStudentPositionInCleaningOrder(student.getCleanOrder());
                if (index != -1) {
                    insertStudentToCleaningOrder(index, student);
                }
            }
        }
    }

    private void insertStudentToCleaningOrder(int index, Student student) {
        if (cleaningOrder[index] != null) {
            for (int i = cleaningOrder.length - 2; i >= index; i--) {
                cleaningOrder[i + 1] = cleaningOrder[i];
            }
        }
        cleaningOrder[index] = student;
    }

    private int findStudentPositionInCleaningOrder(int cleanOrder) {
        for (int i = 0; i < cleaningOrder.length; i++) {
            if (cleaningOrder[i] == null || cleaningOrder[i].getCleanOrder() > cleanOrder) {
                return i;
            }
        }
        return -1;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public String getNextCleaningStudentName() {
        return cleaningOrder[0] == null ? "" : cleaningOrder[0].getFullName();
    }

    public Optional<Student> getStudentForChairById(int chairId) {
        for (Table table : tables) {
            if(table != null) {
                Optional<Student> student = table.getStudentForChairById(chairId);
                if (student.isPresent()) {
                    return student;
                }
            }
        }
        return Optional.empty();
    }

    public Student getOldestStudentAtNthTable(int tableNumber) {
        if (numberOfTables >= tableNumber) {
            return tables[tableNumber - 1].getOldestStudent();
        }
        return null;
    }
}
