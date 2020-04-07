package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateTable implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;

    public CreateTable(ExecutionEnvironment env, String... args) {
        this.env = env;
        this.databaseName = args[1];
        this.tableName = args[2];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            env.getDatabase(databaseName).get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Table created");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}