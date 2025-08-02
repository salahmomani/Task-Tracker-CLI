package com.salah.Command;

import com.salah.Service.Service;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Arrays;

public class AddCommand implements Command {
    private Service service;
    private static final Logger LOGGER = Logger.getLogger(AddCommand.class.getName());

    public AddCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {


            if (args.length < 2) {
                System.out.println("please see the help sheet by write help command");
                ;
            } else {
                String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                service.add(description);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
