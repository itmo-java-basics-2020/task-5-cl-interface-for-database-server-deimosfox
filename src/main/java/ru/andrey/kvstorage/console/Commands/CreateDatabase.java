package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;


public class CreateDatabase implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;

    public CreateDatabase(ExecutionEnvironment env, String... args) {
        this.env = env;
        this.databaseName = args[1];
    }

    @Override
    public DatabaseCommandResult execute() {
        return null;
    }
}


