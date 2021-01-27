package com.example.intenttuongminh;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String studentCode;
    private String studentName;
    private String studentGender;
    private String studentClass;

    public Student() {
    }

    public Student(String studentCode, String studentName, String studentGender, String studentClass) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentClass = studentClass;
    }

    protected Student(Parcel in) {
        studentCode = in.readString();
        studentName = in.readString();
        studentGender = in.readString();
        studentClass = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String output(){
        return studentCode + " - " + studentName + " - " + studentGender + " - " + studentClass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentCode);
        dest.writeString(studentName);
        dest.writeString(studentGender);
        dest.writeString(studentClass);
    }
}

