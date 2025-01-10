class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        // First, add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Directions for moving in 4 directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // Use a 2D array to represent directions

        // Perform BFS to rot the oranges
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int x = rotten[0];
                int y = rotten[1];

                // Try all 4 possible directions (up, down, left, right)
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Make the orange rotten
                        freshOranges--; // Decrease the count of fresh oranges
                        queue.offer(new int[]{newX, newY}); // Add to queue to propagate rotting
                    }
                }
            }
            minutes++; // One minute passed for each level of BFS
        }

        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutes : -1;
    }
}
