package com.salah;

public class ListToDoCommand implements Command{
    private Service service;

    public ListToDoCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 3) {
                System.out.println("the correct command: list todo \"id\"");
            } else {
                service.listTodo().forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("failed list toDo task");
        }
    }
}
