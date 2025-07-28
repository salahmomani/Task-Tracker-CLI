package com.salah.Command;

import com.salah.Service.Service;

public class ListCommand implements Command {
    public Service service;

    public ListCommand(Service service) {
        this.service = service;
    }
    @Override
    public void execute(String[] args) {
        try {
            if (args.length == 1) {

                System.out.println("all tasks");
                service.listAll().forEach(System.out::println);
//
//                System.out.println("TODO:");
//                service.listTodo().forEach(System.out::println);
//                System.out.println("\nIN PROGRESS:");
//                service.listInProgress().forEach(System.out::println);
//                System.out.println("\nDONE:");
//                service.listDone().forEach(System.out::println);
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
                }
            } else {
                System.out.println("Invalid command usage. Usage: list [todo|done|in-progress]");
            }
        } catch (Exception e) {
            System.out.println("Failed to list tasks: " + e.getMessage());
        }
    }
}
