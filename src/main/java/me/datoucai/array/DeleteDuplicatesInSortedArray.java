package me.datoucai.array;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/?tdsourcetag=s_pctim_aiomsg
 */
public class DeleteDuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int index = sort(nums);
        System.out.println(index);
    }

    private static int sort(int[] nums) {
        int flag = 0;
        if (nums.length < 2) {
            return nums.length;
        }
        if (nums[0] < nums[1]) {
            flag++;
        }

        int index = 1;
        int indexNum = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > indexNum) {
                //出现相同时候才换位置
                if (nums[index] <= nums[index - 1]) {
                    nums[index] = nums[i];
                }
                indexNum = nums[index];
                i = ++index;
            }
            if (i == nums.length) {
                return index;
            }
        }
        if (index < 3) {
            index = index + flag;
        }
        return index;
    }

}
