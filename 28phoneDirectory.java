
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // List to store the results for each prefix
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        // Iterate through each prefix of the query string s
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);  // Get the current prefix
            
            // List to store contacts that match the current prefix
            ArrayList<String> matchingContacts = new ArrayList<>();
            
            // Check each contact if it starts with the current prefix
            for (String c : contact) {
                if (c.startsWith(prefix)) {
                    matchingContacts.add(c);
                }
            }
            
            // If we have matching contacts, sort them lexicographically
            if (matchingContacts.size() > 0) {
                Collections.sort(matchingContacts);
                result.add(matchingContacts);
            } else {
                // If no contacts match, add "0"
                result.add(new ArrayList<>(Collections.singletonList("0")));
            }
        }
        
        return result;
    }
}
