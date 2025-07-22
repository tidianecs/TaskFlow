package com.tidiane.taskFlow.State;

public class DoneState implements TaskState {
    @Override
    public TaskState start() {
        throw new IllegalStateException("Cannot restart a completed task.");
    }

    @Override
    public TaskState complete() {
        throw new IllegalStateException("Task already completed.");
    }

    @Override
    public String getStatusName() {
        return "DONE";
    }
}
