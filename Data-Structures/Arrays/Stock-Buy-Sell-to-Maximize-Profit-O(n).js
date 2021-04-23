/**
 * Given a list of stock prices for n days, find the maximum profit with a single buy or sell activity.
 */

/**
 * Runtime Complexity: Linear O(n)
 * Memory Complexity: Constant O(1)
 */

/**
 * Initialize:
 *  current buying price: first value of array
 *  global selling price: second value of array
 *  global profit: second value - first value of array
 * 
 * Steps:
 * Loop over entire array starting from second position
 *  Update current profit - by subtracting current buying price from current iteration value
 *  Update current buying price by current iteration value - If current iteration value is lesser
 *  Update global profit by current profit and global selling price by current iteration value - If global profit is lesser
 * 
 * Return [global selling price - global profit = global buying price] and global selling price
 */

let findBuySellStockPrices = function(arr) {

  if(!arr && arr.length < 2) {
    return;
  }

  let currBuy = arr[0];
  let globalSell = arr[1];
  let globalProfit = arr[1] - arr[0];

  let currProfit = 0;

  for (let i = 1; i < arr.length; i++) {
    currProfit = arr[i] - currBuy;

    if (arr[i] < currBuy) {
      currBuy = arr[i];
    }

    if (globalProfit < currProfit) {
      globalProfit = currProfit;
      globalSell = arr[i];
    }


  }
  return [globalSell - globalProfit, globalSell]
}


// Tests
console.log(findBuySellStockPrices([8, 5, 12, 9, 19, 1])); // 5, 19
console.log(findBuySellStockPrices([21, 12, 11, 9, 6, 3])); // 12, 11
// console.log(findBuySellStockPrices([1,2,3,4,3,2,1,2,5])); // [1, 5] [buy, sell]
// console.log(findBuySellStockPrices([8,6,5,4,3,2,1])); // [6, 5]
