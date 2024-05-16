package array;

public class Search {
    public static void main(String[] args) {
        int[] test = new int[]{2,3,8,9,12,15};
        int target = 16;
        int i = binarySearch(test, target);
        System.out.println("二分结果为"+i);
    }

    /**
     * 二分查找算法，用于在有序整数数组中查找指定目标值。
     *
     * 左闭右闭写法注意点：
     *  1、循环条件left<=right，因为当left=right时由于right能取到最右，仍有讨论意义
     *  2、nums[mid]>target时，right=mid-1
     *
     * @param nums 有序整数数组，需保证数组升序排列
     * @param target 要在数组中查找的目标值
     * @return 目标值在数组中的索引，如果目标值不存在于数组中，则返回负数。具体地，返回最接近目标值且小于目标值的元素的索引的相反数
     */
    public static int binarySearch(int[] nums,int target){
        int left = 0;  // 初始化搜索区间的左边界
        int right = nums.length-1;  // 初始化搜索区间的右边界
        while(left<=right){  // 当搜索区间不为空时循环
            int mid = left+(right-left)/2;  // 计算搜索区间的中间位置，避免溢出
            if(nums[mid]>target){  // 如果中间位置的元素大于目标值
                right = mid-1;  // 缩小搜索区间至中间位置的左半部分
            }else if(nums[mid]<target){  // 如果中间位置的元素小于目标值
                left = mid+1;  // 缩小搜索区间至中间位置的右半部分
            }else{
                return mid;  // 如果中间位置的元素等于目标值，直接返回中间位置
            }
        }
        // 当循环结束时，目标值不存在于数组中，则返回最接近目标值且小于目标值的元素的索引的相反数
        return (-1)*left;
    }
}
