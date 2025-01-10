class Solution {
    public String convertToTitle(int columnNumber) {
         StringBuilder columnTitle = new StringBuilder();

        while (columnNumber > 0) {
            // Find the remainder when columnNumber is divided by 26
            int remainder = (columnNumber - 1) % 26;
            // Convert the remainder to a character (A to Z)
            char letter = (char) (remainder + 'A');
            columnTitle.append(letter);
            // Update columnNumber to consider the next digit
            columnNumber = (columnNumber - 1) / 26;
        }

        // Reverse the string because we build it from the least significant digit
        return columnTitle.reverse().toString();
    }
}
