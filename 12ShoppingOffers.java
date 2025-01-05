class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
         // Convert the List types into arrays for easier handling
        int[] priceArr = new int[price.size()];
        for (int i = 0; i < price.size(); i++) {
            priceArr[i] = price.get(i);
        }

        int[][] specialArr = new int[special.size()][price.size() + 1];
        for (int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            for (int j = 0; j < offer.size(); j++) {
                specialArr[i][j] = offer.get(j);
            }
        }

        int[] needsArr = new int[needs.size()];
        for (int i = 0; i < needs.size(); i++) {
            needsArr[i] = needs.get(i);
        }

        // Use a memoization map to store previously computed results for unique need combinations
        Map<String, Integer> memo = new HashMap<>();

        // Start the recursive function with memoization
        return dfs(priceArr, specialArr, needsArr, memo);
    }

    private int dfs(int[] price, int[][] special, int[] needs, Map<String, Integer> memo) {
        // Convert the current needs array to a string key for memoization
        String key = getKey(needs);

        // If the result for the current needs combination has been computed before, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Calculate the total cost without using any special offers
        int result = 0;
        for (int i = 0; i < price.length; i++) {
            result += price[i] * needs[i];
        }

        // Try applying each special offer and recursively calculate the minimum cost
        for (int[] offer : special) {
            // Check if we can apply this offer (i.e., the needs are sufficient for the offer)
            int[] newNeeds = needs.clone();
            boolean validOffer = true;
            for (int i = 0; i < price.length; i++) {
                newNeeds[i] -= offer[i];
                if (newNeeds[i] < 0) {
                    validOffer = false;
                    break;
                }
            }

            // If the offer is valid, calculate the cost recursively
            if (validOffer) {
                result = Math.min(result, offer[price.length] + dfs(price, special, newNeeds, memo));
            }
        }

        // Memoize the result and return it
        memo.put(key, result);
        return result;
    }

    private String getKey(int[] needs) {
        // Convert the needs array into a string key to store in the memo map
        StringBuilder key = new StringBuilder();
        for (int need : needs) {
            key.append(need).append(',');
        }
        return key.toString();
    }
}
