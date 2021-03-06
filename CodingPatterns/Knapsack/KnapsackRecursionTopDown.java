package CodingPatterns.Knapsack;

/**
 * 
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 * 
 * Max Profit: 10 (Take Weights 1 and 4)
 * 
 * Combinations with Total weight is not more than 5
 * Apple + Orange (total weight 5) => 9 profit
 * Apple + Banana (total weight 3) => 7 profit
 * Orange + Banana (total weight 4) => 8 profit
 * Banana + Melon (total weight 5) => 10 profit  <-- Best combinations
 */

/**
 * Runtime: Exponential O(2^n)
 * where ‘n’ represents the total number of items.
 * This can also be confirmed from the recursion tree this algorithm creates.
 * We will have a total of ‘31’ recursive calls – calculated through (2^n) + (2^n) - 1
 * which is asymptotically equivalent to O(2^n)
 * 
 * Memory: O(n)
 * This space will be used to store the recursion stack.
 * Since the recursive algorithm works in a depth-first fashion, which means that 
 * we can’t have more than ‘n’ recursive calls on the call stack at any time.
 */
class KnapsackRecursionTopDown {
    int count = 0;

    public int getMaxProfit(int[] profits, int[] weights, int capacity) {
        return getMaxProfitR(profits, weights, capacity, 0); // Start from the 0th index of 'weights'
    }

    // currentIdx for 'weights' array
    public int getMaxProfitR(int[] profits, int[] weights, int capacity, int currentIdx) {
        // Base checks
        if (capacity <= 0 || currentIdx >= profits.length) {
            return 0;
        }
        // SELECT
        int profit1 = 0;
        if (weights[currentIdx] <= capacity) { // Do not process, if the weight of the element at currentIdx exceeds the capacity
            // Reduce capacity
            profit1 = profits[currentIdx] + getMaxProfitR(profits, weights, capacity - weights[currentIdx], currentIdx + 1);
        }
        // SKIP
        int profit2 = getMaxProfitR(profits, weights, capacity, currentIdx + 1);

        this.count++;
        return Math.max(profit1, profit2);
    }
  
    public static void main(String[] args) {
        KnapsackRecursionTopDown ks = new KnapsackRecursionTopDown();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.getMaxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 22
        System.out.println(ks.count + " times called"); // 15 -> Using memoization, we can reduce this number
        maxProfit = ks.getMaxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 17
    }
  }
