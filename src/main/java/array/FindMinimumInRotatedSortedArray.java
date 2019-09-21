package array;

public class FindMinimumInRotatedSortedArray {
    /**
     * Default version
     * <p>
     * Time: O(log n) <br>
     * Space: O(1)
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new UnsupportedOperationException("Array is null or empty");

        int left = 0;
        int right = nums.length - 1;

        // Not rotated respectively rotated by 0
        // or nums.length == 1
        // This exploits the fact that numbers are unique
        if (nums[0] <= nums[right])
            return nums[0];

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0])
                left = mid + 1;
            else
                right = mid - 1;
        }

        throw new IllegalStateException("Execution should never get here");
    }
}
