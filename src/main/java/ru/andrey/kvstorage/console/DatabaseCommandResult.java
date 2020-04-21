package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String newInfo) {
        return new DatabaseCommandResultImpl(true, newInfo);
    }

    static DatabaseCommandResult error(String newInfo) {
        return new DatabaseCommandResultImpl(false, newInfo);
    }

    class DatabaseCommandResultImpl implements DatabaseCommandResult {
        private String info;
        private boolean isSucceeded;

        private DatabaseCommandResultImpl(boolean isSucceeded, String newInfo) {
            this.isSucceeded = isSucceeded;
            info = newInfo;
        }

        @Override
        public Optional<String> getResult() {
            return isSucceeded ? Optional.of(info) : Optional.empty();
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return isSucceeded ? DatabaseCommandStatus.SUCCESS : DatabaseCommandStatus.FAILED;
        }

        @Override
        public boolean isSuccess() {
            return isSucceeded;
        }

        @Override
        public String getErrorMessage() {
            return isSucceeded ? null : info;
        }
    }
}