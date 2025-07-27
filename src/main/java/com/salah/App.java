package com.salah;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskRepo repo = new TaskRepo("Task.json");
        Service service = new Service(repo);

        CommandMap commandMap = new CommandMap();
        commandMap.selectCommand("add", new AddCommand(service));
        commandMap.selectCommand("list", new ListCommand(service));
        commandMap.selectCommand("list done", new ListDoneCommand(service));
        commandMap.selectCommand("delete", new DeleteCommand(service));
        commandMap.selectCommand("update", new UpdateCommand(service));
        commandMap.selectCommand("mark-done", new MarkDone(service));
        commandMap.selectCommand("mark-in-progress", new MarkInProgress(service));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Task CLI started. Enter commands (type 'exit' to quit).");

        while (true) {
            System.out.print("task-cli> ");
            String inputLine = scanner.nextLine();
            if (inputLine.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }
            if (inputLine.trim().isEmpty()) {
                continue;
            }

            String[] inputArgs = inputLine.trim().split("\\s+");
            String commandName = inputArgs[0];

            Command command = commandMap.getCommand(commandName);
            if (command != null) {
                command.execute(inputArgs);
            } else {
                System.out.println("Unknown command: " + commandName);
            }
        }

        scanner.close();
    }
}

