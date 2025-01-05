class Solution {
    public void wiggleSort(int[] nums) {
         Arrays.sort(nums);
        
        // Temporary array to store the result
        int[] result = new int[nums.length];
        
        int left = (nums.length + 1) / 2 - 1;  // The last index of the left half
        int right = nums.length - 1;           // The last index of the right half
        
        // Fill the result array
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[left--];    // Place from the left half for even indices
            } else {
                result[i] = nums[right--];   // Place from the right half for odd indices
            }
        }
        
        // Copy the result back into the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
