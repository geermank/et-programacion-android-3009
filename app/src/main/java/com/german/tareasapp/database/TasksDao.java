package com.german.tareasapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.german.tareasapp.models.Task;

import java.util.List;

@Dao
public interface TasksDao {

    @Query("SELECT * FROM Tasks")
    List<Task> getAll();

    @Query("SELECT * FROM Tasks WHERE id = :id")
    Task get(int id);

    @Insert
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
