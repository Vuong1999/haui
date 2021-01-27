package com.example.extend_exercise_1117;

import androidx.room.*;

import java.util.List;

@Dao
public interface JobInWeekDao {
    @Query("SELECT * FROM JobInWeek")
    List<JobInWeek> getAll();

    @Query("SELECT * FROM JobInWeek WHERE title LIKE :title")
    JobInWeek getUserByName(String title);

    @Insert
    void insertJobInWeek(JobInWeek... jobInWeeks);

    @Delete
    void deleteJobInWeek(JobInWeek... jobInWeeks);

    @Update
    void updateJobInWeek(JobInWeek... jobInWeeks);
}