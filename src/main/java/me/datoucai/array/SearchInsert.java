package me.datoucai.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * https://leetcode-cn.com/problems/search-insert-position/description/
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9};
        System.out.println(searchInsert(nums, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right)  //循环条件，适时而变
        {
            int middle = left + ((right - left) >> 1);  //防止溢出，移位也更高效。同时，每次循环都需要更新。
            if (nums[middle] > target)
                right = middle - 1;  //right赋值，适时而变
            else if (nums[middle] < target)
                left = middle + 1;
            else
                return middle;
        }
        return left;
    }
}
