class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] exist1 = new boolean[26];
        boolean[] exist2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            exist1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            exist2[c - 'a'] = true;
        }

        // Check if both words use the same characters
        for (int i = 0; i < 26; i++) {
            if (exist1[i] != exist2[i]) return false;
        }

        // Sort and compare frequencies
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
