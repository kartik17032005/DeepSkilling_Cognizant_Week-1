package Week_1.DSA.Library_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch"));
        books.add(new Book(3, "Design Patterns", "Erich Gamma"));
        books.add(new Book(4, "Head First Java", "Kathy Sierra"));
        books.add(new Book(5, "Introduction to Algorithms", "Thomas H. Cormen"));

        System.out.println("-------BOOKS-------");
        System.out.println(books);

        System.out.println();

        //linear Search
        System.out.println("------LINEAR SEARCH-------");
        int target = 4;
        for(int i = 0; i< books.size(); i++){
            if(books.get(i).getBookId() == (target)){
                System.out.println(books.get(i));
                break;
            }
        }

        System.out.println();

        //Binary Search
        System.out.println("------BINARY SEARCH-------");
        int start = 0;
        int end = books.size()-1;

        int target1 = 5;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(books.get(mid).getBookId() == (target1)){
                System.out.println(books.get(mid));
                break;
            }
            else if(books.get(mid).getBookId() < target1){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

    }
}
