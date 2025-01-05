class Solution {
    public int[][] imageSmoother(int[][] img) {
         int m = img.length;       // Number of rows
        int n = img[0].length;    // Number of columns
        int[][] result = new int[m][n];

        // Iterate through each cell in the image
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Traverse the 3x3 grid around the cell (i, j)
                for (int row = i - 1; row <= i + 1; row++) {
                    for (int col = j - 1; col <= j + 1; col++) {
                        // Check if (row, col) is within bounds
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            sum += img[row][col];
                            count++;
                        }
                    }
                }

                // Calculate the smoothed value
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
