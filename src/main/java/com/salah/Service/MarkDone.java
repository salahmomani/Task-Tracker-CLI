package com.salah.Service;

import com.salah.Command.Command;
import com.salah.Task.Task;
import com.salah.repo.TaskRepo;

import java.util.logging.*;

public class MarkDone implements Command {
    private Service service;

    public MarkDone(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(MarkDone.class.getName());

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("the correct command: mark-done \"id\"");

            } else {
                int id = Integer.parseInt(args[1]);
                boolean result = service.markDone(id);
                if (result) {
                    System.out.println("Task with ID " + id + " marked as DONE.");
                } else {
                    System.out.println("Task not found.");
                }

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
