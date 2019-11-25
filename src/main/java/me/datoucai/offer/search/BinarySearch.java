package me.datoucai.offer.search;

/**
 * @author dengtongcai
 * @date 2019-11-25 10:38 上午
 **/
public class BinarySearch {

    static int search(int[] array, int key) {
        int startIndex = 0;
        int endIndex = array.length;
          while (startIndex <= endIndex) {
            int midIndex = (endIndex - startIndex) / 2 + startIndex;
            int midValue = array[midIndex];

            if (midValue == key) {
                return midIndex;
            } else if (midValue < key) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(search(srcArray, 21));
    }

}
