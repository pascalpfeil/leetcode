package string;

public class LongestRepeatingCharacterReplacement {
    /**
     * Default version with a sliding window
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int characterReplacement(String s, int k) {
        int sLength = s.length();

        int[] map = new int[26]; //only uppercase letters

        int maxLength = 0;
        int maxCount = 0;

        int left = 0;
        int right = 0;

        while (right < sLength) {
            maxCount = Math.max(maxCount, ++map[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k)
                map[s.charAt(left++) - 'A']--;

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }

    /**
     * Version where the sliding window does not get smaller.
     * Seems more optimized but was only half as fast on leetcode
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int characterReplacement2(String s, int k) {
        int sLength = s.length();
        int[] map = new int[26]; //only uppercase letters
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < sLength; right++) {
            maxCount = Math.max(maxCount, ++map[s.charAt(right) - 'A']);

            if (right - left + 1 - maxCount > k)
                map[s.charAt(left++) - 'A']--;
        }

        return sLength - left;
    }
}
