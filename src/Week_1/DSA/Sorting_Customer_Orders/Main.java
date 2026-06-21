package Week_1.DSA.Sorting_Customer_Orders;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).getTotalPrice();

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot) {
                i++;

                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }

    static void main() {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("O1", "Kartik Choudhary", 2000));
        orders.add(new Order("O2", "Ankur kumar", 4000));
        orders.add(new Order("O3", "John Doe", 1599));
        orders.add(new Order("O4", "Kapil Lilhore", 200));
        orders.add(new Order("O5", "Emma Richards", 5000));

        //bubble sort
        for(int i = 0; i< orders.size()-1; i++){
            for(int j = 0; j< orders.size()-i-1; j++){
                if(orders.get(j).getTotalPrice() > orders.get(j+1).getTotalPrice()){
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j+1));
                    orders.set(j+1, temp);
                }
            }
        }

        System.out.println("----BUBBLE SORT----");
        for(int i = 0; i< orders.size(); i++){
            Order order = orders.get(i);
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }


        System.out.println("----QUICK SORT----");
        quickSort(orders, 0, orders.size() - 1);

        for (Order order : orders) {
            System.out.println(
                    order.getOrderId() + " " +
                            order.getCustomerName() + " " +
                            order.getTotalPrice()
            );
        }
    }
}
