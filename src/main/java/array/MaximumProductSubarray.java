package array;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumProductSubarray {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currentMin = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current1 = nums[i];
            int current2 = current1 * currentMax;
            int current3 = current1 * currentMin;


            currentMin = min(current1, min(current2, current3));
            currentMax = max(current1, max(current2, current3));

            if (currentMax > maxProduct)
                maxProduct = currentMax;
        }

        return maxProduct;
    }
}
