package Week_1.DSA.Employee_Management_System;

public class Main {
    static void main() {
       Employee[] employees = new Employee[5];

       //add
        employees[0] = new Employee("E001", "Kartik Choudhary", "Software Engineer", 60000);
        employees[1] = new Employee("E002", "Ankur Kumar", "Data Analyst", 55000);
        employees[2] = new Employee("E003", "John Doe", "Project Manager", 90000);
        employees[3] = new Employee("E004", "Emma Richards", "HR Manager", 50000);
        employees[4] = new Employee("E005", "Kapil Lilhore", "DevOps Engineer", 70000);

        //traverse
        for(int i = 0; i< employees.length; i++){
            System.out.println(employees[i]);
        }

        //search
        String target = "E003";
        System.out.println("Searching.....");
        for(int i = 0; i< employees.length; i++){
            if(employees[i].getEmployeeId().equals(target)){
                System.out.println(employees[i]);
                break;
            }
        }

        //delete
        String target1 = "E003";
        System.out.println("Deleting.....");
        for(int i = 0; i< employees.length; i++){
            if(employees[i].getEmployeeId().equals(target1)){
                employees[i] = null;
                break;
            }
        }

        for(int i = 0; i< employees.length; i++){
            System.out.println(employees[i]);
        }



    }
}
