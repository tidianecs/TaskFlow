package com.tidiane.taskFlow.State;

public class InGoingState implements TaskState {
    @Override
    public TaskState start() {
        throw new IllegalStateException("Task already in progress.");
    }

    @Override
    public TaskState complete() {
        return new DoneState();
    }

    @Override
    public String getStatusName() {
        return "IN_GOING";
    }
}
