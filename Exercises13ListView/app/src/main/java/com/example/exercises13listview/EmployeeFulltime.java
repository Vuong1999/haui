package com.example.exercises13listview;

public class EmployeeFulltime extends Employee {
    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() +" -->FullTime="+TinhLuong();
    }
}
