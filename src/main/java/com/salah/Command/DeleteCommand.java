package com.salah.Command;

import com.salah.Service.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteCommand implements Command {
    private Service service;

    public DeleteCommand(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(DeleteCommand.class.getName());

    @Override
    public void execute(String[] args) {
        try {

            if (!service.isNumeric(args[1])) {
                System.out.println("Task ID must be a valid number.");
                return;
            }

            if (args.length != 2) {
                System.out.println("please see the help sheet by write help command");

            } else {
                int id = Integer.parseInt(args[1]);
                if (id < 1) {
                    System.out.println("Invalid ID");
                }
                service.deleteTask(id);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}