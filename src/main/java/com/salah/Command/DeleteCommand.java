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
            if (args.length != 2) {
                System.out.println("the correct command: delete \"id\"");
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