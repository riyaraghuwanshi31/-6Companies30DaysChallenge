class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;
        int i = 1; // Start from the second element

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                // Find the left boundary of the mountain
                int left = i - 1;
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Find the right boundary of the mountain
                int right = i + 1;
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int mountainLength = right - left + 1;
                longest = Math.max(longest, mountainLength);

                // Move i to the end of the current mountain
                i = right;
            } else {
                i++;
            }
        }

        return longest;
    }
}
