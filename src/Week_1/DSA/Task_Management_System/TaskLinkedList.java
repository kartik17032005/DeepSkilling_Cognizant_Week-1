package Week_1.DSA.Task_Management_System;


public class TaskLinkedList {

    private Node head;

    // Add Task
    public void add(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Traverse Tasks
    public void traverse() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Search Task by ID
    public Task search(int taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }

    // Delete Task by ID
    public void delete(int taskId) {

        if (head == null) {
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}