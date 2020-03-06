package com.theloocale.absencetracker.model;

public class Lesson {
    private String id, name;
    private int rightToAbsence;

    public Lesson(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
