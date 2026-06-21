package Week_1.Design_Patterns.DependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository repository;

    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerName(String id) {
        return repository.findCustomerById(id);
    }
}
