package Week_1.DSA.Financial_Forecasting;

public class Main {
    public static void main(String[] args) {
        runDemo();
    }

    static void main() {
        runDemo();
    }

    private static void runDemo() {
        System.out.println("==================================================");
        System.out.println("         FINANCIAL FORECASTING SYSTEM             ");
        System.out.println("==================================================\n");

        double initialInvestment = 1000.0;
        double constantRate = 0.05;
        int years = 10;

        System.out.println("--- Scenario 1: Constant Growth Rate ---");
        System.out.printf("Initial Investment: $%.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.1f%%%n", constantRate * 100);
        System.out.printf("Forecasting Horizon: %d years%n", years);

        double futureValRec = FinancialForecasting.calculateFutureValue(initialInvestment, constantRate, years);
        System.out.printf("[Recursive] Future Value: $%.2f%n", futureValRec);

        double futureValIter = FinancialForecasting.calculateFutureValueIterative(initialInvestment, constantRate, years);
        System.out.printf("[Iterative] Future Value: $%.2f%n", futureValIter);
        System.out.println();

        System.out.println("--- Scenario 2: Variable Past Growth Rates ---");
        double[] variableRates = {0.05, 0.04, 0.06, 0.03, 0.055, 0.045, 0.07, 0.02, 0.05, 0.06};
        System.out.printf("Applying variable rates: [");
        for (int i = 0; i < variableRates.length; i++) {
            System.out.printf("%.1f%%", variableRates[i] * 100);
            if (i < variableRates.length - 1) System.out.printf(", ");
        }
        System.out.println("]");

        double futureValVar = FinancialForecasting.calculateFutureValueWithVariableRates(initialInvestment, variableRates, variableRates.length);
        System.out.printf("Future Value after %d years: $%.2f%n", variableRates.length, futureValVar);
        System.out.println();

        System.out.println("--- Scenario 3: Performance & Call Stack Optimization Analysis ---");
        int largePeriods = 10000;
        System.out.printf("Attempting to forecast %d periods...%n", largePeriods);

        System.out.print("[Standard Recursion] ");
        try {
            long startTime = System.nanoTime();
            double res = FinancialForecasting.calculateFutureValue(initialInvestment, constantRate, largePeriods);
            long endTime = System.nanoTime();
            System.out.printf("Success! Future Value: $%.2e (Time: %.3f ms)%n", res, (endTime - startTime) / 1e6);
        } catch (StackOverflowError e) {
            System.out.println("FAILED due to StackOverflowError (Stack Limit Exceeded).");
        }

        System.out.print("[Memoized Recursion] ");
        double[] memo = new double[largePeriods + 1];
        try {
            long startTime = System.nanoTime();
            double res = FinancialForecasting.calculateFutureValueMemoized(initialInvestment, constantRate, largePeriods, memo);
            long endTime = System.nanoTime();
            System.out.printf("Success! Future Value: $%.2e (Time: %.3f ms)%n", res, (endTime - startTime) / 1e6);
        } catch (StackOverflowError e) {
            System.out.println("FAILED due to StackOverflowError (Recursive depth limit).");
        }

        System.out.print("[Iterative Approach] ");
        long startTime = System.nanoTime();
        double resIter = FinancialForecasting.calculateFutureValueIterative(initialInvestment, constantRate, largePeriods);
        long endTime = System.nanoTime();
        System.out.printf("Success! Future Value: $%.2e (Time: %.3f ms, Space: O(1))%n", resIter, (endTime - startTime) / 1e6);
        System.out.println();

        System.out.println("==================================================");
    }
}
