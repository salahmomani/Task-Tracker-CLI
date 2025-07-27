package com.salah;

import java.util.Arrays;

public class AddCommand implements Command {
    private Service service;

    public AddCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {


            if (args.length < 2) {
                System.out.println("the correct command: add \"description\" ");
            } else {
                String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                service.add(description);
            }
        } catch (Exception e) {
            System.out.println("failed add task");
        }
    }
}
