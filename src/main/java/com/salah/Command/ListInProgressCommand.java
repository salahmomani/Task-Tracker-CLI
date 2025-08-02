package com.salah.Command;

import com.salah.Service.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListInProgressCommand implements Command {
    private Service service;

    public ListInProgressCommand(Service service) {
        this.service = service;
    }
    private static final Logger LOGGER = Logger.getLogger(ListInProgressCommand.class.getName());

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("please see the help sheet by write help command");
            } else {
                service.listInProgress().forEach(System.out::println);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}

