package Week_1.Design_Patterns.DependencyInjectionExample;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Populating mock database
        customers.put("C101", "Emma Watson");
        customers.put("C102", "Robert Downey Jr.");
        customers.put("C103", "Scarlett Johansson");
    }

    @Override
    public String findCustomerById(String id) {
        return customers.getOrDefault(id, "Customer Not Found");
    }
}
