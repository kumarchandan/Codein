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
 * Runtime:
 * 
 * Memory: 
 */
class KnapsackBottomUpIterative {

    public int getMaxProfit(int[] profits, int[] weights, int capacity) {

        // base checks
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }

        int n = profits.length;
        int[][] lookupTable = new int[n][capacity + 1];

        // Populate capacity=0 columns. With '0' capacity we have '0' profit
        for (int i = 0; i < n; i++) {
            lookupTable[i][0] = 0;
        }

        // Pre-fill 0th index, with first index's weight
        // If we have only one weight, take it if it is not more than the capacity
        for (int w = 0; w < capacity; w++) {
            if (weights[0] <= w) {
                lookupTable[0][w] = profits[0];
            }
        }

        // Process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int w = 1; w <= capacity; w++) {
                int profit1 = 0, profit2 = 0;
                // Include the item, if it is not more than the capacity
                if (weights[i] <= w) {
                    // profit -> current index profit + previous index profit
                    profit1 = profits[i] + lookupTable[i-1][w-weights[i]];
                }
                // Exclude the item, Pick the profit of previous Index
                profit2 = lookupTable[i-1][w];
                // Take maximum
                lookupTable[i][w] = Math.max(profit1, profit2);
            }
        }
        // Maximum profit at the Bottom-Right corner
        return lookupTable[n-1][capacity];
    }
  
    public static void main(String[] args) {
        KnapsackBottomUpIterative ks = new KnapsackBottomUpIterative();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.getMaxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 22
        maxProfit = ks.getMaxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 17
    }
  }