package com.salah.Service;

import com.salah.Task.Task;
import com.salah.repo.TaskRepo;
import com.salah.Status.TaskStatus;

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

        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + id + " not found.");
        }
        task.setUpdateAt(LocalDateTime.now());
        task.setDescription(description);
        repo.save();
    }

    public boolean markDone(int id) {
        Task task = repo.findTaskID(id);
        if (task != null) {
            task.setStatus(TaskStatus.DONE);
            task.setUpdateAt(LocalDateTime.now());

            listTodo().removeIf(t -> t.getId() == id);
            listInProgress().removeIf(t -> t.getId() == id);
            if (!listDone().contains(task)) {
                listDone().add(task);
            }
            repo.save();
            return true;
        }
        return false;
    }

    public boolean markInProgress(int id) {
        Task task = repo.findTaskID(id);
        if (task != null) {
            task.setStatus(TaskStatus.IN_PROGRESS);
            task.setUpdateAt(LocalDateTime.now());
            listTodo().removeIf(t -> t.getId() == id);
            listDone().removeIf(t -> t.getId() == id);
            if (!listInProgress().contains(task)) {
                listInProgress().add(task);
            }
            repo.save();
            return true;
        }
        return false;
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
