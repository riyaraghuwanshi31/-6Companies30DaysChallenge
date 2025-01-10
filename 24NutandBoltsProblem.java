class Solution {
    
      private static final char[] ORDER = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
    
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
// Create a map for predefined order
        int[] orderMap = new int[256];
        for (int i = 0; i < ORDER.length; i++) {
            orderMap[ORDER[i]] = i;
        }

        // Convert char arrays to Character arrays
        Character[] nutsObj = new Character[n];
        Character[] boltsObj = new Character[n];
        
        for (int i = 0; i < n; i++) {
            nutsObj[i] = nuts[i];
            boltsObj[i] = bolts[i];
        }

        // Sort nuts and bolts based on the predefined order using comparators
        Arrays.sort(nutsObj, (a, b) -> Integer.compare(orderMap[a], orderMap[b]));
        Arrays.sort(boltsObj, (a, b) -> Integer.compare(orderMap[a], orderMap[b]));

        // Convert Character arrays back to char arrays
        for (int i = 0; i < n; i++) {
            nuts[i] = nutsObj[i];
            bolts[i] = boltsObj[i];
        }
    }
}
