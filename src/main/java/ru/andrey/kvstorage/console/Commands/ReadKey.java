package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;

public class ReadKey implements DatabaseCommand {
    private ExecutionEnvironment env;
    private String databaseName;
    private String tableName;
    private String key;
    private Integer noa;


    public ReadKey(ExecutionEnvironment env, String... args) {
        this.noa=args.length;
        this.env = env;
        this.databaseName = args[1];
        this.tableName = args[2];
        this.key = args[3];
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if(noa!= 4) {
            return DatabaseCommandResult.error("This command required 3 option");
        }
        try {
            return DatabaseCommandResult.
                    success(env.getDatabase(databaseName).get().read(tableName, key));
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
