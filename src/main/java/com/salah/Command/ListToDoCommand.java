package com.salah.Command;

import com.salah.Service.Service;

import java.util.logging.*;

public class ListToDoCommand implements Command {
    private Service service;

    public ListToDoCommand(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(ListToDoCommand.class.getName());

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("the correct command: list todo \"id\"");
            } else {
                service.listTodo().forEach(System.out::println);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
