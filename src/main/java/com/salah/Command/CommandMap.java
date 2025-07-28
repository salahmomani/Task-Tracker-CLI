package com.salah.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    private Map<String, Command> commandMap = new HashMap<>();

    public void selectCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}
