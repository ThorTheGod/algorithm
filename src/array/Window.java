package array;

public class Window {
    /**
     *     给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     *     示例：
     *
     *     输入：s = 7, nums = [2,3,1,2,4,3]
     *     输出：2
     *     解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *     提示：
     *
     *             1 <= target <= 10^9
     *             1 <= nums.length <= 10^5
     *             1 <= nums[i] <= 10^5
     */
    public static void main(String[] args) {

        int[] arr = {2,3,1,2,4,3};
        int s = 7;
        //滑动窗口法（本质也是双指针）
        int length = slidingWindow(arr, s);
    }

    /**
     * 计算数组中滑动窗口的最小长度
     * 注意点：
     *     1. 以右指针j作为循环索引
     *     2. 当满足条件时，才移动左指针i，从而避免暴力嵌套循环的o(n^2)
     *     3. 移动前，窗口长度为j-i+1
     *     4. 每个元素都被遍历了2次，复杂度为o(2n)，即j和i都遍历了一遍，但并不是嵌套遍历
     * @param arr 输入的整数数组
     * @param s 窗口的最小和
     * @return 返回满足最小和要求的滑动窗口的最小长度
     */
    public static int slidingWindow(int[] arr, int s) {
        // 初始化指针i和j，以及窗口和sum为0
        int i = 0;
        int j = 0;
        int sum = 0;
        // 初始化窗口最小长度为整型最大值
        int min = Integer.MAX_VALUE;

        // 遍历数组
        while (j < arr.length) {
            // 累加窗口内的元素和
            sum += arr[j];
            // 如果窗口内的和小于s，则仅移动右指针j
            if (sum < s) {
                j++;
                continue;
            }
            // 如果窗口内的和大于等于s，则更新最小窗口长度，并且移动左指针i
            min = Math.min(min, j - i + 1);
            sum -= arr[i];
            i++;
        }
        // 返回最小窗口长度
        return min;
    }
}
