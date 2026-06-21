package Week_1.Design_Patterns.DependencyInjectionExample;

public class Main {
    static void main() {
        // Create the dependency (repository)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the dependency into the service
        CustomerService service = new CustomerService(repository);

        // Fetch and print customers
        System.out.println("--- Fetching Customer Details ---");
        System.out.println("Customer C101: " + service.getCustomerName("C101"));
        System.out.println("Customer C102: " + service.getCustomerName("C102"));
        System.out.println("Customer C104: " + service.getCustomerName("C104"));
    }
}
