package array;

import java.util.*;

public class TwoSum {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};

            map.put(target - nums[i], i);
        }

        throw new UnsupportedOperationException("Array did not contain solution");
    }

    /**
     * This version could be used to exploit sorted input
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int[] twoSumWithSort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int current = nums[left] + nums[right];

            if (current == target)
                return new int[]{left, right};
            else if (current < target)
                left++;
            else // current > target
                right--;
        }

        throw new UnsupportedOperationException("Array did not contain solution");
    }
}
