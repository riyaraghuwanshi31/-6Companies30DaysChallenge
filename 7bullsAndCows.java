class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        // Maps to store the frequency of digits that are not bulls
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        // Step 1: Count bulls and populate frequency maps for non-bull digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++; // Count bulls
            } else {
                // Track non-bull digits
                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
            }
        }

        // Step 2: Count cows by comparing frequency of digits in both maps
        for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
            char digit = entry.getKey();
            int guessCount = entry.getValue();
            int secretCount = secretMap.getOrDefault(digit, 0);

            // Cows are the minimum of the digit's count in both maps
            cows += Math.min(guessCount, secretCount);
        }

        // Return the result in "xAyB" format
        return bulls + "A" + cows + "B";
    }
}
