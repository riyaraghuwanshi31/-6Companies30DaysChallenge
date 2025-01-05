class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        
        // Initialize the cost matrix with maximum values
        final long INF = Long.MAX_VALUE; // Arbitrary large value for impossible transformations
        long[][] minCost = new long[26][26];  // 26 letters in the alphabet

        // Initialize all the costs as infinite except self-loops
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    minCost[i][j] = 0;
                } else {
                    minCost[i][j] = INF;
                }
            }
        }

        // Populate the cost matrix with the given transformations
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        // Use the Floyd-Warshall algorithm to find the minimum cost between every pair of characters
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;

        // Calculate the total cost for transforming source into target
        for (int i = 0; i < n; i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            
            // If it's impossible to convert sourceChar to targetChar, return -1
            if (minCost[sourceChar][targetChar] == INF) {
                return -1;
            }
            
            totalCost += minCost[sourceChar][targetChar];
        }

        return totalCost;
    }
}
