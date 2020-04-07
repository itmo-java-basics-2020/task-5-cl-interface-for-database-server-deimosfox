package ru.andrey.kvstorage.console.Commands;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.*;

public enum DatabaseCommands {
    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CreateDatabase(env, args);
        }
    },
    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CreateTable(env, args);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new UpdateKey(env, args);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new ReadKey(env, args);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String[] args);
}