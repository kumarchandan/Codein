package Arrays;

public class StockBuySellToMaximizeProfit {
    public static String findBuySellPrices(int[] arr) {

        int currentBuy = arr[0];
        int currentProfit = 0;

        int globalSell = arr[1];
        int globalProfit = arr[1] - arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            // Current Profit = Current Sell - Current Buy
            currentProfit = arr[i] - currentBuy;

            if (arr[i] < currentBuy) {
                currentBuy = arr[i];
            }
            
            if (globalProfit < currentProfit) {
                globalProfit = currentProfit;
                globalSell = arr[i];
            }
        }

        int globalBuy = globalSell - globalProfit;
        return String.valueOf(globalBuy) + ", " + String.valueOf(globalSell);
    }
    public static void main(String[] args) {
        int[] arr = {8, 5, 12, 9, 19, 1}; // 5, 19  -> buy, sell
        int[] arr2 = {21, 12, 11, 9, 6, 3}; // 12, 11
        System.out.println(StockBuySellToMaximizeProfit.findBuySellPrices(arr));
        System.out.println(StockBuySellToMaximizeProfit.findBuySellPrices(arr2));
    }
}
