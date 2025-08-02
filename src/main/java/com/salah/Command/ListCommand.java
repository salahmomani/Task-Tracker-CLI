package com.salah.Command;

import com.salah.Service.Service;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListCommand implements Command {
    private Service service;

    public ListCommand(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(ListCommand.class.getName());

    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 1) {

                service.listAll().forEach(System.out::println);

            } else if (args.length == 2) {
                switch (args[1].toLowerCase()) {
                    case "todo":
                        service.listTodo().forEach(System.out::println);
                        break;
                    case "done":
                        service.listDone().forEach(System.out::println);
                        break;
                    case "in-progress":
                        service.listInProgress().forEach(System.out::println);
                        break;
                    default:
                        System.out.println("Unknown list filter: " + args[1]);
                        System.out.println("please see the help sheet by write help command");

                }
            } else {
                System.out.println("Invalid command usage. Usage: list [todo|done|in-progress]");
                System.out.println("please see the help sheet by write help command");

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
