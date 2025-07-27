package com.salah;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepo {
    List<Task> allTasks = new ArrayList<Task>();
    List<Task> toDoTasks = new ArrayList<Task>();
    List<Task> doneTasks = new ArrayList<Task>();
    List<Task> inProgressTasks = new ArrayList<Task>();

    private final String fileName;

    public TaskRepo(String fileName) {
        this.fileName = fileName;
    }


    public List<Task> showAllTasks() {
        return allTasks;
    }

    public List<Task> showToDoTasks() {
        return toDoTasks;
    }

    public List<Task> showInProgress() {
        return inProgressTasks;
    }

    public List<Task> showDoneTasks() {
        return doneTasks;
    }

    private List<Task> getTasksByStatus(TaskStatus status) {
        return allTasks.stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public void add(Task task) {
        allTasks.add(task);
        toDoTasks.add(task);
        save();
    }

    public void remove(Task task) {
        allTasks.remove(task);
        save();
    }

    public void save() {

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("[\n");
            for (int i = 0; i < allTasks.size(); i++) {
                writer.write(allTasks.get(i).toJson());
                if (i < allTasks.size() - 1) writer.write(",\n");
            }
            writer.write("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Task findTaskID(int id) {
        allTasks.
                stream().
                filter(t -> t.getId() == id).
                findFirst().
                orElse(null);
        return null;
    }

}
