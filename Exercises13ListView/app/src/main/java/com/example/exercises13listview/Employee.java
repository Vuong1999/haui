package com.example.exercises13listview;

public abstract class Employee {
    private String id;
    private String name;

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    private boolean Gender;

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
    public abstract double TinhLuong();
    @Override
    public String toString() {
        return this.id+" - "+this.name;
    }
}
