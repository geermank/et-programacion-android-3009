package com.german.tareasapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String assignedTo;
    private boolean closed;

    public Task() { }

    public Task(String title, String assignedTo) {
        this.title = title;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
