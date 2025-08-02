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
                System.out.println("please see the help sheet by write help command");

            } else {
                int id = Integer.parseInt(args[1]);
                boolean result = service.markDone(id);
                if (result) {
                    System.out.println("Task with ID " + id + " marked as DONE.");
                } else {
                    if (id < 1) {
                        System.out.println("id invalid");
                    } else {
                        System.out.println("Task not found.");
                    }
                }

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
