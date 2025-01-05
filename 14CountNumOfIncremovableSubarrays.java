class Solution {

private boolean isStrictlyIncreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Iterate over all possible subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                
                // Create a new array excluding the subarray nums[start..end]
                int[] remaining = new int[n - (end - start + 1)];
                int index = 0;
                
                // Copy elements before the subarray
                for (int i = 0; i < start; i++) {
                    remaining[index++] = nums[i];
                }
                
                // Copy elements after the subarray
                for (int i = end + 1; i < n; i++) {
                    remaining[index++] = nums[i];
                }
                
                // Check if the remaining array is strictly increasing
                if (isStrictlyIncreasing(remaining)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
