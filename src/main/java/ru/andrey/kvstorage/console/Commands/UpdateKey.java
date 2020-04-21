package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;

public class UpdateKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;
    private String value;
    private Integer noa;

    public UpdateKey(ExecutionEnvironment env, String... args) {
        this.noa=args.length;
        this.env = env;
        this.databaseName = args[1];
        this.tableName = args[2];
        this.key = args[3];
        this.value = args[4];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if(noa!= 5) {
            return DatabaseCommandResult.error("This command required 4 option");
        }
        try {
            env.getDatabase(databaseName).get().write(tableName, key, value);
            return DatabaseCommandResult.success("Data written");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
