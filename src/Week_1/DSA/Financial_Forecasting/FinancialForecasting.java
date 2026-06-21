package Week_1.DSA.Financial_Forecasting;

import java.util.Arrays;

public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods <= 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static double calculateFutureValueWithVariableRates(double presentValue, double[] growthRates, int periods) {
        if (periods <= 0 || growthRates == null || growthRates.length == 0) {
            return presentValue;
        }
        int index = Math.min(periods, growthRates.length) - 1;
        double rate = growthRates[index];
        return calculateFutureValueWithVariableRates(presentValue, growthRates, periods - 1) * (1 + rate);
    }

    public static double calculateFutureValueMemoized(double presentValue, double growthRate, int periods, double[] memo) {
        if (periods <= 0) {
            return presentValue;
        }
        if (memo[periods] != 0.0) {
            return memo[periods];
        }
        memo[periods] = calculateFutureValueMemoized(presentValue, growthRate, periods - 1, memo) * (1 + growthRate);
        return memo[periods];
    }

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
