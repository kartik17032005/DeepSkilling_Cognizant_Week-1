package Week_1.DSA.Task_Management_System;

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class Main {
    static void main() {

        TaskLinkedList tasks = new TaskLinkedList();

        tasks.add(new Task("Pending", "Complete Assignment", 101));
        tasks.add(new Task("In Progress", "Learn Linked List", 102));
        tasks.add(new Task("Completed", "Submit Project", 103));
        tasks.add(new Task("Pending", "Practice DSA", 104));
        tasks.add(new Task("Completed", "Attend Meeting", 105));

        System.out.println("---- ALL TASKS ----");
        tasks.traverse();

        System.out.println("\n---- SEARCH TASK 103 ----");
        System.out.println(tasks.search(103));

        System.out.println("\n---- DELETE TASK 102 ----");
        tasks.delete(102);

        System.out.println("\n---- AFTER DELETION ----");
        tasks.traverse();

    }

}
