package com.tidiane.taskFlow.State;

public interface TaskState {
    TaskState start();
    TaskState complete();
    String getStatusName();
}

