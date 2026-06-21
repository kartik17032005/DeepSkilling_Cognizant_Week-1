package Week_1.DSA.Task_Management_System;

public class Task {
    int taskId;
    String taskName;
    String status;

    public Task(String status, String taskName, int taskId) {
        this.status = status;
        this.taskName = taskName;
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
