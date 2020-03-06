package com.theloocale.absencetracker.model;

public class Lesson {
    private String id;
    private String name;
    private int rightToAbsence;

    public Lesson(String id, String name, int rightToAbsence) {
        this.id = id;
        this.name = name;
        this.rightToAbsence = rightToAbsence;
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

    public int getRightToAbsence() {
        return rightToAbsence;
    }

    public void setRightToAbsence(int rightToAbsence) {
        this.rightToAbsence = rightToAbsence;
    }
}
