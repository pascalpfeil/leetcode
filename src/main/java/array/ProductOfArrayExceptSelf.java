package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] run(int[] nums) {
        return new ProductOfArrayExceptSelf().productExceptSelf(nums);
    }

    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1) without the result array
     */
    private int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int zeroIndex = -1;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                } else {
                    // If there are more than one zeros in the list, every element will be zero
                    Arrays.fill(nums, 0);
                    return result;
                }
            } else {
                product *= nums[i];
            }
        }

        if (zeroIndex == -1) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }

        }
        // If there is a single zero in the list, every other element will be zero
        else {
            for (int i = 0; i < nums.length; i++) {
                result[i] = i == zeroIndex ? product : 0;
            }
        }

        return result;
    }
}
