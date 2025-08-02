package com.salah.Main;

import com.salah.Command.*;
import com.salah.Service.MarkDone;
import com.salah.Service.MarkInProgress;
import com.salah.Service.Service;
import com.salah.repo.TaskRepo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskRepo repo = new TaskRepo("Task.json");
        Service service = new Service(repo);

        CommandMap commandMap = new CommandMap();
        commandMap.selectCommand("add", new AddCommand(service));
        commandMap.selectCommand("list", new ListCommand(service));
        commandMap.selectCommand("list done", new ListDoneCommand(service));
        commandMap.selectCommand("list todo", new ListToDoCommand(service));
        commandMap.selectCommand("list in-progress", new ListInProgressCommand(service));
        commandMap.selectCommand("delete", new DeleteCommand(service));
        commandMap.selectCommand("update", new UpdateCommand(service));
        commandMap.selectCommand("mark-done", new MarkDone(service));
        commandMap.selectCommand("mark-in-progress", new MarkInProgress(service));
        commandMap.selectCommand("help", new HelpCommand());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Task CLI started. Enter commands 'exit' to quit.");
        System.out.println("To get help Enter \"help\" command");
        while (true) {
            System.out.print("task-cli> ");
            String commandLine = scanner.nextLine();
            if (commandLine.trim().equals("exit")) {
                System.out.println("End the process");
                break;
            }
            if (commandLine.trim().isEmpty()) {
                continue;
            }

            String[] inputArgs = commandLine.trim().split("\\s+");
            String commandName = inputArgs[0];

            Command command = commandMap.getCommand(commandName);
            if (command != null) {
                command.execute(inputArgs);
            } else {
                System.out.println("Unknown command: " + commandName);
                System.out.println("please see the help sheet by write help command");

            }
        }

        scanner.close();
    }
}

