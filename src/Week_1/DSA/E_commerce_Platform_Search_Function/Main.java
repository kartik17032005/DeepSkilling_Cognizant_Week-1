package Week_1.DSA.E_commerce_Platform_Search_Function;

public class Main {

    static void main() {
        Product[] products = new Product[5];

        products[0] = new Product(1, "Mouse", "Electronics");
        products[1] = new Product(2, "Laptop", "Electronics");
        products[2] = new Product(3, "Cereals", "Food");
        products[3] = new Product(4, "TV", "Electronics");
        products[4] = new Product(5, "JAR", "General");

        //linear search (O(n))
        int target = 3;
        for(Product product: products){
           if(product.getProductId() == target){
               System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getCategory());
           }
        }

        //binary Search (O(log(n))
        int target1 = 4;

        int start = 0;
        int end = products.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            Product product = products[mid];

            if(product.getProductId() == (target1)){
                System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getCategory());
                break;
            }
            else if(product.getProductId() < target1){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
    }


}
