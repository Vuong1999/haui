package com.example.test_20201208;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public static final String TAG = "SQLHelper";
    public static final String DB_NAME = "SinhVien.sb";
    public static final String DB_NAME_TABLE = "SinhVien";
    public static final int DB_VERSION = 6;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String QueryCreateTable = "CREATE TABLE SinhVien ( " +
                "maSV INTEGER NOT NULL PRIMARY KEY ," +
                "tenSV Text, " +
                "diemTB Text, " +
                "lop Text )";
        sqLiteDatabase.execSQL(QueryCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("drop table if exists " + DB_NAME_TABLE);
            onCreate(sqLiteDatabase);
        }
    }
    // insert một phần tử mới vào db
    public void insertSV(String maSV, String tenSV, String diemTB, String lop) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("maSV", maSV);
        contentValues.put("tenSV", tenSV);
        contentValues.put("diemTB", diemTB);
        contentValues.put("lop", lop);
        sqLiteDatabase.insert(DB_NAME_TABLE, null, contentValues);
        closeDB();
    }

    // xóa một phần tử
    public int deleteSV(String maSV) {
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(DB_NAME_TABLE, " maSV=?",
                new String[]{String.valueOf(maSV)});
    }

    // xóa tất cả các phần tử
    public boolean delAll() {
        int result;
        sqLiteDatabase = getWritableDatabase();
        result = sqLiteDatabase.delete(DB_NAME_TABLE, null, null);
        closeDB();
        if (result == 1) return true;
        else return false;
    }

    // cập nhật 1 phần tử
    public void updateProduct(String maSV, String tenSV, String diemTB, String lop) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("maSV", maSV);
        contentValues.put("tenSV", tenSV);
        contentValues.put("diemTB", diemTB);
        contentValues.put("lop", lop);
        sqLiteDatabase.update(DB_NAME_TABLE, contentValues, "maSV=? ",
                new String[]{String.valueOf(maSV)});
        closeDB();
    }


    public List<SinhVien> getAllSVAdvanced() {
        List<SinhVien> sv = new ArrayList<>();
        SinhVien sinhVien;

        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(false, DB_NAME_TABLE, null, null, null
                , null, null, null, null);
        while (cursor.moveToNext()) {
            String maSV = cursor.getString(cursor.getColumnIndex("maSV"));
            String tenSV = cursor.getString(cursor.getColumnIndex("tenSV"));
            String diemTB = cursor.getString(cursor.getColumnIndex("diemTB"));
            String lop = cursor.getString(cursor.getColumnIndex("lop"));
            sinhVien = new SinhVien(maSV, tenSV,diemTB,lop);
            sv.add(sinhVien);
        }
        closeDB();
        return sv;
    }
    public List<SinhVien> getAllSVAdvanced1(String tl) {
        List<SinhVien> sv = new ArrayList<>();
        SinhVien sinhVien;

        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.query(false, DB_NAME_TABLE, null, null, null
                , null, null, null, null);
        while (cursor.moveToNext()) {
            String maSV = cursor.getString(cursor.getColumnIndex("maSV"));
            String tenSV = cursor.getString(cursor.getColumnIndex("tenSV"));
            String diemTB = cursor.getString(cursor.getColumnIndex("diemTB"));
            String lop = cursor.getString(cursor.getColumnIndex("lop"));
            if(lop.compareTo(tl)==0)
            {
                sinhVien = new SinhVien(maSV, tenSV,diemTB,lop);
                sv.add(sinhVien);
            }
        }
        closeDB();
        return sv;
    }

    // đóng cơ sở dữ liệu sau khi thực hiện xong các câu lệnh truy vấn
    private void closeDB() {
        if (sqLiteDatabase != null) sqLiteDatabase.close();
        if (contentValues != null) contentValues.clear();
        if (cursor != null) cursor.close();
    }
}
