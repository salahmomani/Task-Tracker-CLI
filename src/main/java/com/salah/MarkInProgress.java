package com.salah;

public class MarkInProgress implements Command {
    private Service service;

    public MarkInProgress(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {

        try {
            if (args.length != 2) {
                System.out.println("the correct command: mark-done \"id\"");

            } else {
                int id = Integer.parseInt(args[1]);
                service.markDone(id);
            }
        } catch (Exception e) {
            System.out.println("failed mark this task done");
        }
    }
}
