package com.salah.Command;

import com.salah.Service.Service;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateCommand implements Command {
    private Service service;

    public UpdateCommand(Service service) {
        this.service = service;
    }

    private static final Logger LOGGER = Logger.getLogger(UpdateCommand.class.getName());

    @Override
    public void execute(String[] args) {
        try {
            if (args.length < 3) {
                System.out.println("the correct command: update \"id\" \"new description\"");
            } else {
                int id = 0;
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    LOGGER.log(Level.SEVERE, "An error occurred", e);

                }
                if (id < 1) {
                    System.out.println("Invalid ID");
                    return;
                }
                String description = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                service.update(id, description);

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
