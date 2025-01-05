class Solution {

    private int[][] rects;
    private int[] prefixSum;
    private int totalPoints;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        this.random = new Random();

        // Calculate the prefix sum of points for each rectangle
        totalPoints = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int width = rect[2] - rect[0] + 1; // (xi - ai + 1)
            int height = rect[3] - rect[1] + 1; // (yi - bi + 1)
            totalPoints += width * height;
            prefixSum[i] = totalPoints; // Prefix sum
        }
    }

    public int[] pick() {
        // Step 1: Pick a rectangle using the prefix sum
        int target = random.nextInt(totalPoints) + 1; // 1-based index
        int rectIndex = binarySearch(target);

        // Step 2: Pick a point within the chosen rectangle
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int low = 0, high = prefixSum.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
