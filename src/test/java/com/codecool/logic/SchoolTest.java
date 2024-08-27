package com.codecool.logic;

import com.codecool.model.Chair;
import com.codecool.model.Room;
import com.codecool.model.Student;
import com.codecool.model.Table;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    private School school;

    @Test
    void getNextCleaningStudentNameWhenNoStudentIsPresentReturnsEmptyString() {
        Room room = new Room();
        school = new School(Set.of(room));

        String expected = "";
        String actual = school.getNextCleaningStudentName(room);

        assertEquals(expected, actual);
    }

    @Test
    void getNextCleaningStudentNameWhenOneStudentIsPresentReturnsStudentsName() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);

        Table table = new Table();
        table.addStudent(student, chair);

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));

        String expected = "Michael Smith";
        String actual = school.getNextCleaningStudentName(room);

        assertEquals(expected, actual);
    }

    @Test
    void getNextCleaningStudentNameWhenTwoStudentIsPresentReturnsCorrectStudentsName() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);
        Student student2 = new Student("Martha", "Jones", 14, 2);
        Chair chair2 = new Chair(2);

        Table table = new Table();
        table.addStudent(student, chair);
        Table table2 = new Table();
        table2.addStudent(student2, chair2);

        Room room = new Room();
        room.addTable(table);
        room.addTable(table2);

        school = new School(Set.of(room));

        String expected = "Michael Smith";
        String actual = school.getNextCleaningStudentName(room);

        assertEquals(expected, actual);
    }

    @Test
    void getStudentForChairByIdWhenNoRoomsExistReturnsNull() {
        school = new School(Set.of());
        assertNull(school.getStudentForChairById(1));
    }

    @Test
    void getStudentForChairByIdWhenNoTablesExistReturnsNull() {
        Room room = new Room();
        school = new School(Set.of(room));
        assertNull(school.getStudentForChairById(1));
    }

    @Test
    void getStudentForChairByIdWhenNoChairsExistReturnsNull() {
        Table table = new Table();

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));
        assertNull(school.getStudentForChairById(1));
    }

    @Test
    void getStudentForChairByIdWhenNoChairByIdExistReturnsNull() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(2);

        Table table = new Table();
        table.addStudent(student, chair);

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));
        assertNull(school.getStudentForChairById(1));
    }

    @Test
    void getStudentForChairByIdWhenChairByIdExistReturnsStudent() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);

        Table table = new Table();
        table.addStudent(student, chair);

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));
        assertEquals(student, school.getStudentForChairById(1));
    }

    @Test
    void getStudentForChairByIdWhenChairByIdExistAndOtherChairsArePresentReturnsCorrectStudent() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);
        Student student2 = new Student("martha", "Jones", 14, 3);
        Chair chair2 = new Chair(2);
        Student student3 = new Student("Peter", "Stone", 13, 5);
        Chair chair3 = new Chair(3);

        Table table = new Table();
        table.addStudent(student, chair);
        table.addStudent(student2, chair2);

        Table table2 = new Table();
        table2.addStudent(student3, chair3);

        Room room = new Room();
        room.addTable(table);

        Room room2 = new Room();
        room.addTable(table2);

        school = new School(Set.of(room, room2));
        assertEquals(student, school.getStudentForChairById(1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereAreNoTablesInRoomReturnsNull() {
        Room room = new Room();
        school = new School(Set.of(room));

        assertNull(school.getOldestStudentAtNthTable(room, 1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereAreLessTablesInRoomThanAskedReturnsNull() {
        Table table = new Table();

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));

        assertNull(school.getOldestStudentAtNthTable(room, 2));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereIsOneTablesWithOneStudentInRoomReturnsStudent() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);

        Table table = new Table();
        table.addStudent(student, chair);

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));

        assertEquals(student, school.getOldestStudentAtNthTable(room, 1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereIsOneTablesWithMoreStudentInRoomReturnsCorrectStudent() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);
        Student student2 = new Student("martha", "Jones", 14, 3);
        Chair chair2 = new Chair(2);
        Student student3 = new Student("Peter", "Stone", 13, 5);
        Chair chair3 = new Chair(3);

        Table table = new Table();
        table.addStudent(student, chair);
        table.addStudent(student2, chair2);
        table.addStudent(student3, chair3);

        Room room = new Room();
        room.addTable(table);

        school = new School(Set.of(room));

        assertEquals(student2,school.getOldestStudentAtNthTable(room, 1));
    }

    @Test
    void getOldestStudentAtNthTableWhenThereIsTwoTablesWithStudentInRoomReturnsCorrectStudent() {
        Student student = new Student("Michael", "Smith", 13, 1);
        Chair chair = new Chair(1);
        Student student2 = new Student("martha", "Jones", 14, 3);
        Chair chair2 = new Chair(2);
        Student student3 = new Student("Peter", "Stone", 13, 5);
        Chair chair3 = new Chair(3);

        Table table = new Table();
        table.addStudent(student, chair);
        table.addStudent(student2, chair2);
        Table table2 = new Table();
        table2.addStudent(student3, chair3);

        Room room = new Room();
        room.addTable(table);
        room.addTable(table2);

        school = new School(Set.of(room));

        assertEquals(student2, school.getOldestStudentAtNthTable(room, 1));
    }

    @Test
    void addRoomDoesNotAddDuplicateRoom() {
        Room room = new Room();
        school = new School(Set.of(room));

        assertEquals(1, school.getNumberOfRooms());
        assertFalse(school.addRoom(room));
        assertEquals(1, school.getNumberOfRooms());
    }
}
