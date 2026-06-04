//438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        // Fill the frequency profile for string p and the initial window of s
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }

        // If the initial window matches, 0 is a starting index
        if (matches(pCounts, sCounts)) {
            result.add(0);
        }

        // Slide the window across the rest of string s
        for (int i = p.length(); i < s.length(); i++) {
            // Add the newly included character on the right
            sCounts[s.charAt(i) - 'a']++;
            // Remove the character that just fell out of the window on the left
            sCounts[s.charAt(i - p.length()) - 'a']--;

            // Check if the updated window matches target frequencies
            if (matches(pCounts, sCounts)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    // Helper method to compare two fixed-size frequency arrays in O(1) time
    private boolean matches(int[] pCounts, int[] sCounts) {
        for (int i = 0; i < 26; i++) {
            if (pCounts[i] != sCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
