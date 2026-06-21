package Week_1.JUnit;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
