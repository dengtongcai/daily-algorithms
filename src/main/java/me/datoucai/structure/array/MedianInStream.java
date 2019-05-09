package me.datoucai.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 有序数据流的中位数
 * 困难
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 */
public class MedianInStream {
    static List<Integer> container = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void addNum(int num) {
        if (container.size() == 0) {
            container.add(num);
            return;
        }

        for (int i = 0; i < container.size(); i++) {
            if (container.get(i) < num && container.get(i + 1) > num) {
                container.add(i + 1, num);
                return;
            }

        }
    }

    public static double findMedian() {
        double rt;
        if (container.size() == 0) {
            return new Double(null);
        }
        //偶数
        if ((container.size() & 1) == 1) {
            rt = container.get((container.size() + 1) >> 2);
        } else {
            rt = (container.get(container.size() >> 2) + container.get((container.size() - 2) >> 2)) >> 2;
        }
        return rt;
    }
}
