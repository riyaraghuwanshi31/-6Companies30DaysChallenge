class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         HashSet<Integer> uniqueElements = new HashSet<>();
        long maxSum = 0;
        long currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Adjust the window to remove duplicates
            while (uniqueElements.contains(nums[right])) {
                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add the current element to the window
            uniqueElements.add(nums[right]);
            currentSum += nums[right];

            // Check if the window size is exactly k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Slide the window by removing the leftmost element
                uniqueElements.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
