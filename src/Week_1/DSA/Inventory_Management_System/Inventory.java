package Week_1.DSA.Inventory_Management_System;

import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product product) {
        if (products.containsKey(productId)) {
            products.put(productId, product);
        }
    }

    public void deleteProduct(String productId) {
        products.remove(productId);
    }


    public void displayProducts() {
        for (Product p : products.values()) {
            System.out.println(
                    p.getProductId() + " " +
                            p.getProductName() + " " +
                            p.getQuantity() + " " +
                            p.getPrice()
            );
        }
    }
}
