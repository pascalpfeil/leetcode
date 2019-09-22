package string;

public class ValidAnagram {
    /**
     * Default version
     * <p>
     * Time: O(s + t) <br>
     * Space: O(1)
     */
    public static boolean isAnagram(String s, String t) {
        int CHAR_COUNT = 26;

        int sLength = s.length();
        int tLength = t.length();

        int[] sArray = new int[CHAR_COUNT];
        int[] tArray = new int[CHAR_COUNT];

        for (int i = 0; i < sLength; i++)
            sArray[s.charAt(i) - 'a']++;


        for (int i = 0; i < tLength; i++)
            tArray[t.charAt(i) - 'a']++;

        for (int i = 0; i < CHAR_COUNT; i++)
            if (sArray[i] != tArray[i])
                return false;

        return true;
    }

    /**
     * Optimized version
     * <p>
     * Time: O(s + t) <br>
     * Space: O(1)
     */
    public static boolean isAnagramOptimized(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength)
            return false;

        int[] array = new int[26];

        for (int i = 0; i < sLength; i++)
            array[s.charAt(i) - 'a']++;


        for (int i = 0; i < tLength; i++)
            if (--array[t.charAt(i) - 'a'] < 0)
                return false;

        return true;
    }
}
