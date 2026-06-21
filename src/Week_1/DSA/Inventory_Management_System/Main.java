package Week_1.DSA.Inventory_Management_System;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product("P101", "Laptop", 10, 50000);
        Product p2 = new Product("P102", "Mouse", 50, 500);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayProducts();

        inventory.updateProduct(
                "P102",
                new Product("P102", "Wireless Mouse", 40, 700)
        );

        inventory.deleteProduct("P101");

        System.out.println("\nAfter Update/Delete:");

        inventory.displayProducts();
    }
}
