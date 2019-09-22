package array;

public class ContainerWithMostWater {
    /**
     * Default version
     * <p>
     * Time: O(n) <br>
     * Space: O(1)
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int currentArea = Math.min(leftHeight, rightHeight) * (right - left);

            if (currentArea > maxArea)
                maxArea = currentArea;

            if (leftHeight < rightHeight)
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
