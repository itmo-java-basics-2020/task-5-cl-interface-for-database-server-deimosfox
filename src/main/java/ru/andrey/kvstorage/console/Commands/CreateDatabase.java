package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;


public class CreateDatabase implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private Integer noa;

    public CreateDatabase(ExecutionEnvironment env, String... args) {
        this.noa = args.length;
        this.env = env;
        this.databaseName = args[1];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (noa != 2) {
            return DatabaseCommandResult.error("This command required 1 option");
        }
        return DatabaseCommandResult.success("Database was created");
    }
}


