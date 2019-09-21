package array;

public class MaximumSubarray {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        //noinspection ForLoopReplaceableByForEach because this would increase memory consumption
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum)
                maxSum = currentSum;

            if (currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }
}
