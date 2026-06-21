# Recursive Algorithms & Optimization in Financial Forecasting

## 1. What is Recursion?
**Recursion** is a programming technique where a method calls itself to solve smaller subproblems of the same problem. Every recursive method must have two fundamental parts:
1. **Base Case:** The condition under which the recursion stops. Without it, the method would execute indefinitely, leading to a stack overflow.
2. **Recursive Step:** The part where the method calls itself with a modified, simpler input that moves closer to the base case.

### How Recursion Simplifies Financial Forecasting
Financial forecasting naturally fits recursion because future values are built sequentially on top of previous values. 
For example, the value of an investment in year $n$ depends directly on the value of the investment in year $n-1$, grown by that year's interest rate. 
Instead of writing complex loops that track state variables across iterations, recursion allows us to model this directly using the mathematical recurrence relation:
$$FV(n) = FV(n-1) \times (1 + r)$$

---

## 2. Complexity Analysis

### Time Complexity
For the constant growth rate algorithm:
- In each recursive call, we perform a single multiplication and subtraction: $FV(n) = FV(n-1) \times (1 + r)$.
- There is exactly $1$ recursive call per level.
- The depth of the recursion tree is $n$ (the number of periods).
- Therefore, the **Time Complexity is $O(n)$**.

### Space Complexity
- Each recursive call creates a new stack frame on the call stack to store local variables, arguments, and return addresses.
- The maximum depth of the call stack is $n$.
- Therefore, the **Space Complexity is $O(n)$** auxiliary space.

---

## 3. The Stack Overflow Problem & Optimizations

### The Problem
Since the call stack size in modern operating systems and JVMs is limited (typically 1MB to 2MB), a large number of periods (e.g., $n = 10,000$ or higher) will cause a `StackOverflowError`. Even though the time complexity is linear, the linear space complexity makes recursion unsafe for large inputs.

### Optimization 1: Memoization (Top-Down Dynamic Programming)
Memoization caches the results of expensive function calls and returns the cached result when the same inputs occur again.
- While memoization avoids redundant recalculations (extremely useful in branching recursion like Fibonacci), for linear recursion like $FV(n)$, its main advantage is speed optimization if the method is called repeatedly.
- However, standard recursive memoization still requires $O(n)$ stack space, so it does not resolve the Stack Overflow issue for a single deep call.

### Optimization 2: Iteration (Bottom-Up Approach)
To completely eliminate the stack space overhead, the recursive algorithm can be converted into an **iterative loop**.
- **Time Complexity:** $O(n)$ (same as recursive).
- **Space Complexity:** $O(1)$ auxiliary space, as it only uses a few local variables instead of allocating new stack frames.
- This prevents `StackOverflowError` entirely and is highly recommended for production financial tools.
