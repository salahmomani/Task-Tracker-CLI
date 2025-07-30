package com.salah.Command;

import com.salah.Service.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListDoneCommand implements Command {
    public Service service;

    public ListDoneCommand(Service service) {
        this.service = service;
    }
    private static final Logger LOGGER = Logger.getLogger(ListDoneCommand.class.getName());

    @Override
    public void execute(String[] args) {

        try {
            if (args.length != 2) {
                System.out.println("the correct command: list done \"id\"");
            } else {
                service.listDone().forEach(System.out::println);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
