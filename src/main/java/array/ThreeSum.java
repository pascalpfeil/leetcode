package array;

import java.util.*;

public class ThreeSum {
    /**
     * Default version
     * <p>
     * Reduces this problem to the {@link TwoSum} problem by transforming a + b + c = 0 to a + b = -c
     * and adding some code for eliminating duplicates
     * <p>
     * Time: O(n^2) <br>
     * Space: O(n)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // avoid duplicates in sorted nums array
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            int target = -1 * nums[i];

            while (left < right) {
                int current = nums[left] + nums[right];

                if (current == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // avoid duplicates in sorted nums array
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                } else if (current < target)
                    left++;
                else // current > target
                    right--;
            }
        }

        return result;
    }

    /**
     * Default version
     * <p>
     * Reduces this problem to the {@link TwoSum} problem by transforming a + b + c = 0 to a + b = -c
     * and using a set for duplicate elimination. This version is slower
     * <p>
     * Time: O(n^2) <br>
     * Space: O(n)
     */
    public static List<List<Integer>> threeSumWithSet(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            int target = -1 * nums[i];

            while (left < right) {
                int current = nums[left] + nums[right];

                if (current == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (current < target)
                    left++;
                else // current > target
                    right--;
            }
        }

        return new ArrayList<>(result);
    }
}
