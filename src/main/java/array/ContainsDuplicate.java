package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        //noinspection ForLoopReplaceableByForEach as it would increase memory consumption
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }

        return false;
    }
}
