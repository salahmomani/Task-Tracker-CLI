package com.salah.Service;

import com.salah.Command.Command;
import com.salah.Task.Task;
import com.salah.repo.TaskRepo;

import java.util.logging.*;

public class MarkInProgress implements Command {
    private Service service;

    public MarkInProgress(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(MarkInProgress.class.getName());

    @Override
    public void execute(String[] args) {
        TaskRepo repo = new TaskRepo("Task.json");

        try {
            if (args.length != 2) {
                System.out.println("the correct command: mark-in-progress \"id\"");
            } else {
                int id = Integer.parseInt(args[1]);

                Task task = repo.findTaskID(id);
                boolean result = service.markInProgress(id);
                if (result) {
                    System.out.println("Task with ID " + id + " marked as IN-PROGRESS.");
                } else {
                    System.out.println("Task not found.");
                }
//                service.markInProgress(id);
//                service.listTodo().remove(id);
//                service.listInProgress().add(task);
//                service.listDone().remove(task);

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
