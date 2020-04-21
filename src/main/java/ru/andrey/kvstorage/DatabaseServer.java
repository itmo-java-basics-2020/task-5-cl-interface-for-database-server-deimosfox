package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.console.Commands.*;
import ru.andrey.kvstorage.exception.*;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.error("Database Server: incoming command text can't be null");
        }

        String[] args = commandText.split(" ");
        String commandName = args[0];
        DatabaseCommand databaseCommand;

        try {
            DatabaseCommands commandWrapper = DatabaseCommands.valueOf(commandName);
            databaseCommand = commandWrapper.getCommand(env, args);
            return databaseCommand.execute();
        } catch (Exception e) {
            if(e.getMessage()!=null) return DatabaseCommandResult.error("<ERROR> Something wrong with this command, more details: " + e.getMessage());
            else return DatabaseCommandResult.error("<ERROR> Something wrong with this command, more details: " + "Unknown error");
        }
    }
}

