package com.example.exercises13listview;

public class EmployeeParttime extends Employee {
    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() +" -->PartTime="+TinhLuong();
    }
}
