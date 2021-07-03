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
class KnapsackBottomUpIterative2 {

    public int getMaxProfit(int[] profits, int[] weights, int capacity) {

        // base checks
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }

        int[][] lookupTable = new int[profits.length + 1][capacity + 1];

        // Building the lookupTable in Bottom up manner
        // 0 -> total capacity
        // |
        // v
        // length of weights
        for (int i = 0; i <= profits.length; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    lookupTable[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    // Formula to fill lookup table -> Max of (previous index profit, prev + this index's profit if eligible)
                    lookupTable[i][w] = Math.max(lookupTable[i-1][w], profits[i-1] + lookupTable[i-1][w-weights[i-1]]);
                } else {
                    lookupTable[i][w] = lookupTable[i-1][w];
                }
            }
        }

        return lookupTable[profits.length][capacity];

    }
  
    public static void main(String[] args) {
        KnapsackBottomUpIterative2 ks = new KnapsackBottomUpIterative2();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.getMaxProfit(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 22
        maxProfit = ks.getMaxProfit(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit); // 17
    }
  }