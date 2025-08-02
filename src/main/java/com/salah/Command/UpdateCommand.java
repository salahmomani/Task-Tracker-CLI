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

    @Override
    public void execute(String[] args) {
        try {
            if (args.length < 3) {
                System.out.println("please see the help sheet by write help command");
                return;
            }

            if (!service.isNumeric(args[1])) {
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
