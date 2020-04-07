package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;

public class ReadKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;

    public ReadKey(ExecutionEnvironment env, String... args) {
        this.env = env;
        this.databaseName = args[1];
        this.tableName = args[2];
        this.key = args[3];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            return DatabaseCommandResult.
                    success(env.getDatabase(databaseName).get().read(tableName, key));
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
