package com.codecool.model;

import java.util.Objects;

public class Chair {
    private final int id;

    public Chair(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return id == chair.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
