package com.salah.Command;

public class HelpCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        System.out.println("  add \"description\"              - Add a new task");
        System.out.println("  list                             - List all tasks");
        System.out.println("  list done                        - List completed tasks");
        System.out.println("  list in-progress                 - List tasks in progress");
        System.out.println("  update <id> <new description>    - Update the task with given ID");
        System.out.println("  delete <id>                      - Delete the task with given ID");
        System.out.println("  mark-done <id>                   - Mark task as done");
        System.out.println("  mark-in-progress <id>            - Mark task as in progress");
        System.out.println("  help                             - Show this help message");
        System.out.println("  exit                             - Exit the application");
    }
}
