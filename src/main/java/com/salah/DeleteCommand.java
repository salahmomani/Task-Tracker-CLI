package com.salah;

public class DeleteCommand implements Command {
    private Service service;

    public DeleteCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("the correct command: delete \"id\"");
            } else {
                int id = Integer.parseInt(args[1]);
                if (id < 1) {
                    System.out.println("Invalid ID");
                }
                service.deleteTask(id);
            }
        } catch (Exception e) {
            System.out.println("failed delete task");
        }
    }
}