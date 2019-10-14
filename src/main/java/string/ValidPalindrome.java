package string;

public class ValidPalindrome {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
