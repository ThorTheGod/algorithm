package array;

public class Remove {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int removeNum = 2;
        System.out.println(removeElement(nums,removeNum));
    }
    /**
     * 移除数组中所有指定元素，并且不考虑超出新长度的剩余元素
     * @param nums 原始数组，包含需要处理的元素
     * @param val 需要移除的元素值
     * @return 移除元素后数组的新长度
     */
    public static int removeElement(int[] nums,int val)
    {
        int len = nums.length; // 获取数组原始长度
        int slow = 0; // 慢指针，用于指向新数组的下一个位置

        // 使用快慢指针法重新排列数组，将不等于val的元素放在数组的前部
        for(int fast = 0;fast<len;fast++)
        {
            if(nums[fast]!=val) // 当快速指针指向的元素不等于val时
            {
                nums[slow] = nums[fast]; // 将该元素移到新数组的当前位置
                slow++; // 慢指针后移，指向新数组的下一个位置
            }
        }
        return slow; // 返回移除元素后的数组长度
    }
}
