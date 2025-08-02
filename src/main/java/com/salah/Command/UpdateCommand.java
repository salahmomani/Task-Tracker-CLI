package com.salah.Command;

import com.salah.Service.Service;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateCommand implements Command {
    private final Service service;
    private static final Logger LOGGER = Logger.getLogger(UpdateCommand.class.getName());

    public UpdateCommand(Service service) {
        this.service = service;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length < 3) {
                System.out.println("The correct command: update <id> <new description>");
                return;
            }

            if (!isNumeric(args[1])) {
                System.out.println("Task ID must be a valid number.");
                return;
            }

            int id = Integer.parseInt(args[1]);
            if (id < 1) {
                System.out.println("Invalid task ID. It must be a positive integer.");
                return;
            }

            String description = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
            service.update(id, description);
            System.out.println("Task with ID " + id + " has been updated successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
