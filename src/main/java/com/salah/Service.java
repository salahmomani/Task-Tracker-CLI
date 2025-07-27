package com.salah;

import java.time.LocalDateTime;
import java.util.List;

public class Service {
    private TaskRepo repo;

    public Service(TaskRepo repo) {
        this.repo = repo;
    }

    public void add(String description) {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(description, TaskStatus.TODO, now, now);
        repo.add(task);
    }

    public void update(int id, String description) {
        Task task = repo.findTaskID(id);
        task.setUpdateAt(LocalDateTime.now());
        task.setDescription(description);
        repo.save();
    }

    public void markDone(int id) {
        Task task = repo.findTaskID(id);
        if (task != null) {
            task.setStatus(TaskStatus.DONE);
            task.setUpdateAt(LocalDateTime.now());
            repo.save();
        }
    }

    public void markInProgress(int id) {
        Task task = repo.findTaskID(id);
        if (task != null) {
            task.setStatus(TaskStatus.IN_PROGRESS);
            task.setUpdateAt(LocalDateTime.now());
            repo.save();
        }
    }

    public void deleteTask(int id) {
        Task task = repo.findTaskID(id);
        if (task != null) {
            repo.remove(task);
        }
        repo.save();
    }

    public List<Task> listAll() {
        return repo.showAllTasks();
    }

    public List<Task> listTodo() {
        return repo.showToDoTasks();
    }

    public List<Task> listInProgress() {
        return repo.showInProgress();

    }

    public List<Task> listDone() {
        return repo.showDoneTasks();
    }
}
