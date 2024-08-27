package com.codecool.logic;

import com.codecool.model.Room;
import com.codecool.model.Student;

import java.util.Collection;
import java.util.Optional;

public class School {
    private final Room[] rooms;
    private int numberOfRooms;

    public School(Collection<Room> rooms) {
        this.rooms = new Room[rooms.size() + 10];
        numberOfRooms = 0;
        for (Room room : rooms) {
            this.rooms[numberOfRooms] = room;
            numberOfRooms++;
        }
    }

    public boolean addRoom(Room room) {
        if(containsRoom(room)) {
            return false;
        }
        if(rooms.length > numberOfRooms) {
            rooms[numberOfRooms] = room;
            numberOfRooms++;
            return true;
        }
        return false;
    }

    private boolean containsRoom(Room roomToAdd) {
        for(Room room : rooms) {
            if(roomToAdd.equals(room)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getNextCleaningStudentName(Room room) {
        return room.getNextCleaningStudentName();
    }

    public Student getStudentForChairById(int chairId) {
        for(Room room: rooms) {
            if(room != null) {
                Optional<Student> student = room.getStudentForChairById(chairId);
                if (student.isPresent()) {
                    return student.get();
                }
            }
        }
        return null;
    }

    public Student getOldestStudentAtNthTable(Room room, int tableNumber) {
        return room.getOldestStudentAtNthTable(tableNumber);
    }
}
