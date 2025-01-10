class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // Step 3: If no unique character is found, return -1
        return -1;
    }
}
