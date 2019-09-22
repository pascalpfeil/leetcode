package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Version with an array and one pass
     * <p>
     * Time: O(n) <br>
     * Space: O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int sLength = s.length();
        int[] map = new int[128]; // 26 to optimize for small letters

        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (right < sLength) {
            int rightChar = s.charAt(right); //  - 'a' to optimize for small letters

            left = Math.max(left, map[rightChar]);

            int currentLength = right - left + 1;
            if (currentLength > maxLength)
                maxLength = currentLength;

            map[rightChar] = ++right;
        }

        return maxLength;
    }

    /**
     * Version with a hashmap and one pass
     * <p>
     * Time: O(n) <br>
     * Space: O(n)
     */
    public static int lengthOfLongestSubstringWithHashMap(String s) {
        int sLength = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (right < sLength) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar) + 1);
            }

            int currentLength = right - left + 1;
            if (currentLength > maxLength)
                maxLength = currentLength;

            map.put(rightChar, right);

            right++;
        }

        return maxLength;
    }

    /**
     * Version with a set and two passes in the worst case
     * <p>
     * Time: O(2n) <br>
     * Space: O(n)
     */
    public static int lengthOfLongestSubstringWithSet(String s) {
        int sLength = s.length();
        Set<Character> set = new HashSet<>();

        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (left < sLength && right < sLength) {
            char rightChar = s.charAt(right);
            if (!set.contains(rightChar)) {
                set.add(rightChar);

                int currentLength = right - left + 1;
                if (currentLength > maxLength)
                    maxLength = currentLength;

                right++;
            } else {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }
        }

        return maxLength;
    }
}
