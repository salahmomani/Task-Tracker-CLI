package com.salah.Command;

import com.salah.Service.Service;

public class ListInProgressCommand implements Command {
    private Service service;

    public ListInProgressCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("the correct command: list in-progress \"id\"");
            } else {
                service.listInProgress().forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("failed list in progress command");
        }
    }
}

