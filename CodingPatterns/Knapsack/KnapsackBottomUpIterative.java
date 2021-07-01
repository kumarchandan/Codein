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
        Integer[][] memory = new Integer[profits.length][capacity + 1]; // capacity + 1 as capacity can reduce until 0
        
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