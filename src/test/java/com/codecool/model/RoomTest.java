package com.codecool.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @BeforeEach
    void setup() {
        room = new Room();
    }

    @Test
    void addTableWhenAddingTableAlreadyInRoomDoesNotAddDuplicateTableAndReturnsFalse() {
        Table table = new Table();

        room.addTable(table);

        assertEquals(1, room.getNumberOfTables());
        assertFalse(room.addTable(table));
        assertEquals(1, room.getNumberOfTables());
    }

    @Test
    void getNextCleaningStudentNameWhenNoStudentsAreInRoomReturnsEmptyString() {
        assertEquals("", room.getNextCleaningStudentName());
    }

    @Test
    void getNextCleaningStudentNameWhenOneStudentIsPresentReturnsTheStudentsName() {
        Student student = new Student("Michael", "Doe", 13, 1);
        Chair chair = new Chair(1);
        Table table = new Table();

        table.addStudent(student, chair);
        room.addTable(table);

        assertEquals("Michael Doe", room.getNextCleaningStudentName());
    }

    @Test
    void getNextCleaningStudentNameWhenTwoStudentAtOneTableArePresentReturnsTheCorrectStudentsName() {
        Student student = new Student("Michael", "Doe", 13, 1);
        Student student2 = new Student("Laura", "Davis", 14, 2);
        Chair chair = new Chair(1);
        Chair chair2 = new Chair(2);
        Table table = new Table();

        table.addStudent(student, chair);
        table.addStudent(student2, chair2);
        room.addTable(table);

        assertEquals("Michael Doe", room.getNextCleaningStudentName());
    }

    @Test
    void getNextCleaningStudentNameWhenTwoStudentsAtDifferentTablesArePresentReturnsTheCorrectStudentsName() {
        Student student = new Student("Michael", "Doe", 13, 2);
        Student student2 = new Student("Laura", "Davis", 14, 1);
        Chair chair = new Chair(1);
        Chair chair2 = new Chair(2);

        Table table = new Table();
        table.addStudent(student, chair);
        Table table2 = new Table();
        table2.addStudent(student2, chair2);

        room.addTable(table);
        room.addTable(table2);

        assertEquals("Laura Davis", room.getNextCleaningStudentName());
    }

    @Test
    void getOldestStudentAtNthTableWhenThereIsOneTableAndOneStudentReturnsStudent() {
        Student student = new Student("Laura", "Davis", 14, 1);
        Chair chair = new Chair(1);

        Table table = new Table();
        table.addStudent(student, chair);

        room.addTable(table);

        assertEquals(student, room.getOldestStudentAtNthTable(1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereIsOneTableAndTwoStudentReturnsCorrectStudent() {
        Student student = new Student("Laura", "Davis", 14, 1);
        Student student2 = new Student("Michael", "Doe", 13, 2);
        Chair chair = new Chair(1);
        Chair chair2 = new Chair(2);

        Table table = new Table();
        table.addStudent(student, chair);
        table.addStudent(student2, chair2);

        room.addTable(table);

        assertEquals(student, room.getOldestStudentAtNthTable(1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereAreTwoTableAndTwoStudentReturnsCorrectStudent() {
        Student student = new Student("Laura", "Davis", 14, 1);
        Student student2 = new Student("Michael", "Doe", 13, 2);
        Chair chair = new Chair(1);
        Chair chair2 = new Chair(2);

        Table table = new Table();
        Table table2 = new Table();
        table.addStudent(student, chair);
        table2.addStudent(student2, chair2);

        room.addTable(table);
        room.addTable(table2);

        assertEquals(student2, room.getOldestStudentAtNthTable(2));
    }
}
