class Solution {

    public int profit(int idx , int tranNo, int prices[] , int n , int k, int dp[][] ){
        if(idx == n || tranNo == 2*k){
            return 0;
        }

        if(dp[idx][tranNo] != -1){
            return dp[idx][tranNo];
        }

        if(tranNo%2 == 0){  //buy
            return dp[idx][tranNo]= Math.max(-prices[idx] + profit(idx+1, tranNo+1, prices, n, k, dp), 0+ profit(idx+1, tranNo, prices, n ,k, dp));
        }

        return dp[idx][tranNo] = Math.max(prices[idx]+ profit(idx+1, tranNo+1, prices, n , k, dp), 0+ profit(idx+1, tranNo, prices, n, k, dp));
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int dp[][] = new int[n][2*k];
    
        for(int i =0; i< dp.length; i++){
             Arrays.fill(dp[i], -1); 
        }

       return profit(0, 0, prices, prices.length, k , dp);
    }
}
