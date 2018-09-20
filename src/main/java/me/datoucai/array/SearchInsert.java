package me.datoucai.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * https://leetcode-cn.com/problems/search-insert-position/description/
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9};
        System.out.println(searchInsert(nums, 1));
        System.out.println(nums);
    }

    public static int searchInsert(int[] nums, int target) {
        int index = nums.length / 2;

        return 0;
    }
}
