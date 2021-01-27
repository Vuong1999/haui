package com.example.extend_exercise_1117;

import androidx.room.TypeConverter;
import java.util.Date;

public class Converter {
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }


}