package com.salah;

import java.util.Arrays;

public class UpdateCommand implements Command {
    private Service service;

    public UpdateCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length < 3) {
                System.out.println("the correct command: update \"id\" \"new description\"");
            } else {
                int id = Integer.parseInt(args[1]);
                String description = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                service.update(id, description);

            }
        } catch (Exception e) {
            System.out.println("invalid id");
        }
    }
}
