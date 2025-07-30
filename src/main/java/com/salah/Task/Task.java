package com.salah.Task;

import com.salah.Status.TaskStatus;

import java.time.LocalDateTime;

public class Task {

    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private static int counter = 1;

    public Task(String description, TaskStatus status, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = counter++;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public static void setCounter(int newCounter) {
        counter = newCounter;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String toJson() {
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"createdAt\": \"" + createdAt.toString() + "\",\n" +
                "  \"updateAt\": \"" + updateAt.toString() + "\"\n" +
                "}";
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
