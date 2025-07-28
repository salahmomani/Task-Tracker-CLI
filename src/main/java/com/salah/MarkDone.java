package com.salah;

public class MarkDone implements Command {
    private Service service;

    public MarkDone(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        TaskRepo repo = new TaskRepo("Task.json");
        try {
            if (args.length != 2) {
                System.out.println("the correct command: mark-done \"id\"");

            } else {
                int id = Integer.parseInt(args[1]);
                Task task = repo.findTaskID(id);
                service.markDone(id);
                service.listTodo().remove(id);
                service.listDone().add(task);

            }
        } catch (Exception e) {
            System.out.println("failed mark this task to done");
        }
    }
}
