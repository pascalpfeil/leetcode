package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(n)
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            Character mapping = mappings.getOrDefault(current, null);

            if (mapping != null) {
                if (stack.empty() || mapping != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }

        return stack.empty();
    }
}
