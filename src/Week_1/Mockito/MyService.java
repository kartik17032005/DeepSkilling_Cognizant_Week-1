package Week_1.Mockito;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void execute() {
        api.doSomething();
    }

    public void executeWithArg(String arg) {
        api.doSomethingWithArg(arg);
    }
}
