package com.salah.repo;

import com.salah.Task.Task;
import com.salah.Status.TaskStatus;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.io.FileWriter;
import java.io.IOException;
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

    private static final Logger LOGGER = Logger.getLogger(TaskRepo.class.getName());

    public void save() {

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("[\n");
            for (int i = 0; i < allTasks.size(); i++) {
                writer.write(allTasks.get(i).toJson());
                if (i < allTasks.size() - 1) writer.write(",\n");
            }
            writer.write("\n]");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }

    public Task findTaskID(int id) {
        for (Task task : allTasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

}
