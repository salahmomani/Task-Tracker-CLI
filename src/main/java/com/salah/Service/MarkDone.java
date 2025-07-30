package com.salah.Service;

import com.salah.Command.Command;
import com.salah.Task.Task;
import com.salah.repo.TaskRepo;

public class MarkDone implements Command {
    private Service service;

    public MarkDone(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        TaskRepo repo = new TaskRepo("Task.json");
        try {
            if (args.length != 2) {
                System.out.println("the correct command: mark-done \"id\"");

            } else {
                int id = Integer.parseInt(args[1]);
             //   Task task = repo.findTaskID(id);
               boolean result= service.markDone(id);
                if (result) {
                    System.out.println("Task with ID " + id + " marked as DONE.");
                } else {
                    System.out.println("Task not found.");
                }
//
//                service.listTodo().remove(id);
//                service.listDone().add(task);
//                service.listInProgress().remove(task);

            }
        } catch (Exception e) {
            System.out.println("failed mark this task to done");
        }
    }
}
