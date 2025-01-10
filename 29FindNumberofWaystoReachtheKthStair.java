class Solution {
    public int waysToReachStair(int k) {
         // Base case: if k is 0, return 2 directly as per problem statement
        if (k == 0) {
            return 2;
        }

        // Memoization map to store already calculated results for each stair
        HashMap<String, Integer> memo = new HashMap<>();
        
        // Start the recursion from stair 1 with an initial jump of 0
        return findWays(k, 1, 0, memo);
    }


     private int findWays(int k, int currentStair, int jump, HashMap<String, Integer> memo) {
        // Base case: if currentStair is k, there's one way to reach here
        if (currentStair == k) {
            return 1;
        }
        
        // If currentStair is less than 0, it's not possible to reach k
        if (currentStair < 0) {
            return 0;
        }

        // Check if the result is already memoized
        String key = currentStair + "," + jump;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Variable to store total ways to reach k
        int totalWays = 0;

        // Operation 1: Go down one stair (only if we're not at stair 0)
        if (currentStair > 0) {
            totalWays += findWays(k, currentStair - 1, jump, memo);
        }

        // Operation 2: Jump up to i + 2^jump
        totalWays += findWays(k, currentStair + (int) Math.pow(2, jump), jump + 1, memo);

        // Store the result in the memoization map and return the result
        memo.put(key, totalWays);
        return totalWays;
    }


}
