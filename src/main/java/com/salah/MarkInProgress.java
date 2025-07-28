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
                System.out.println("the correct command: mark-in-progress \"id\"");
            } else {
                int id = Integer.parseInt(args[1]);
                service.markInProgress(id);
                service.listTodo().remove(id);
            }
        } catch (Exception e) {
            System.out.println("failed mark this task to in-progress");
        }
    }
}
