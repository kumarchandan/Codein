package DynamicProgramming;

/**
 * Given a number sequence, find the length of its Longest Increasing Subsequence (LIS).
 * In an increasing subsequence, all the elements are in increasing order (from lowest to highest).
 * 
 * Ex 1
 * Input: {4,2,3,6,10,1,12}
 * Output: 5
 * Explanation: The LIS is {2,3,6,10,12}.
 * 
 * Ex 2
 * Input: {-4,10,3,7,15}
 * Output: 4
 * Explanation: The LIS is {-4,3,7,15}.
 */
class LongestIncreasingSubsequence {

    public int findLISLength(int[] nums) {
      int[] dp = new int[nums.length];
      dp[0] = 1;    
  
      int maxLength = 1;
      for (int i = 1; i < nums.length; i++) { 
        dp[i] = 1; 
        for (int j = 0; j < i; j++)   
          if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
            dp[i] = dp[j]+1;  
            maxLength = Math.max(maxLength, dp[i]);
          }
      } 
      return maxLength;
    }
  
    public static void main(String[] args) {
      LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
      int[] nums = {4,2,3,6,10,1,12};
      System.out.println(lis.findLISLength(nums));
      nums = new int[]{-4,10,3,7,15};
      System.out.println(lis.findLISLength(nums));
    }
  }