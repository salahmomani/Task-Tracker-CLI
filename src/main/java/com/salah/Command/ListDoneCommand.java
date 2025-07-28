package com.salah.Command;

import com.salah.Service.Service;

public class ListDoneCommand implements Command {
    public Service service;

    public ListDoneCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {

        try {
            if (args.length != 2) {
                System.out.println("the correct command: list done \"id\"");
            } else {
                service.listDone().forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("failed list done task");
        }
    }
}
