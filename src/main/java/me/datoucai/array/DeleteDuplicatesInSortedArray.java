package me.datoucai.array;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/?tdsourcetag=s_pctim_aiomsg
 */
public class DeleteDuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 2, 4, 4, 5, 9};
        int index = sort(ints);
        System.out.println(index);
    }

    private static int sort(int[] ints) {
        if (ints.length < 2) {
            return ints.length;
        }

        int index = 1;
        int indexNum = ints[index];
        for (int i = index + 1; i < ints.length; i++) {
            if (ints[i] > indexNum) {
                ints[index] = ints[i];
                indexNum = ints[index];
                i = ++index;
            }
            if (i == ints.length) {
                return index;
            }
        }

        return index;
    }

}
