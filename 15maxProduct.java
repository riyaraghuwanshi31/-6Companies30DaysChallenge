class Solution {

 

    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;
        
        // Step 1: Generate all subsequences and store their palindromic subsequences
        List<Integer> palindromicSubsequences = new ArrayList<>();
        
        // Generate all subsequences using bitmasking
        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder subsequence = new StringBuilder();
            
            // Build the subsequence corresponding to the current mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsequence.append(s.charAt(i));
                }
            }
            
            // Check if the subsequence is a palindrome
            if (isPalindrome(subsequence.toString())) {
                palindromicSubsequences.add(mask);
            }
        }
        
        // Step 2: Find two disjoint palindromic subsequences
        for (int i = 0; i < palindromicSubsequences.size(); i++) {
            for (int j = i + 1; j < palindromicSubsequences.size(); j++) {
                // Ensure the subsequences are disjoint
                if ((palindromicSubsequences.get(i) & palindromicSubsequences.get(j)) == 0) {
                    int product = Integer.bitCount(palindromicSubsequences.get(i)) *
                                  Integer.bitCount(palindromicSubsequences.get(j));
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        
        return maxProduct;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
