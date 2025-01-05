class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                // Sort by height in descending order if widths are the same
                return b[1] - a[1];
            } else {
                // Sort by width in ascending order
                return a[0] - b[0];
            }
        });

        // Step 2: Find the LIS on the heights
        int[] dp = new int[envelopes.length];
        int length = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int index = Arrays.binarySearch(dp, 0, length, height);
            if (index < 0) {
                index = -(index + 1); // Convert to insertion point
            }
            dp[index] = height;
            if (index == length) {
                length++;
            }
        }

        return length;
    }
}
