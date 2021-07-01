package CodingPatterns.Knapsack;

/**
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 * 
 * Max Profit: 10 (Take Weights 1 and 4)
 */

/**
 * Runtime: Exponential O(N*C)
 * Since our memoization array dp[profits.length][capacity+1] stores the results for all subproblems, 
 * we will not have more than N*C subproblems (where ‘N’ is the number of items and ‘C’ is the knapsack capacity).
 * 
 * Memory: O(N*C + N)
 * O(N*C) for memoization array
 * O(N) for recursion call-stack
 */
class KnapsackRecursionMemoization {

    public int getMaxProfit(int[] profits, int[] weights, int capacity) {
        Integer[][] memory = new Integer[profits.length][capacity + 1]; // capacity + 1 as capacity can reduce until 0
        return getMaxProfitR(memory, profits, weights, capacity, 0); // Start from the 0th index of 'weights'
    }

    // currentIdx for 'weights' array
    public int getMaxProfitR(Integer[][] memory, int[] profits, int[] weights, int capacity, int currentIdx) {
        // Base checks
        if (capacity <= 0 || currentIdx >= profits.length) {
            return 0;
        }

        // If we have already solved the problem, return the result from memory
        if (memory[currentIdx][capacity] != null) {
            return memory[currentIdx][capacity];
        }

        // SELECT
        int profit1 = 0;
        if (weights[currentIdx] <= capacity) { // Do not process, if the weight of the element at currentIdx exceeds the capacity
            // Reduce capacity
            profit1 = profits[currentIdx] + getMaxProfitR(memory, profits, weights, capacity - weights[currentIdx], currentIdx + 1);
        }

        // SKIP
        int profit2 = getMaxProfitR(memory, profits, weights, capacity, currentIdx + 1);

        memory[currentIdx][capacity] = Math.max(profit1, profit2);
        return Math.max(profit1, profit2);
    }
  
    public static void main(String[] args) {
        KnapsackRecursionMemoization ks = new KnapsackRecursionMemoization();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.getMaxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 22
        maxProfit = ks.getMaxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 17
    }
  }