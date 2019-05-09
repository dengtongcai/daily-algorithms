package me.datoucai.dynamic.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * 挖矿最大收益计算
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 *
 * @author cc
 * @date 2019/5/8
 */
@Slf4j
public class DynamicExample9 {
    public static void main(String[] args) {
        HashMap cache = new HashMap<Integer, Integer>();
        log.info("递归解法:{}", recursivePlan(15));
        log.info("备忘录解法:{}", recursiveCachePlan(15, cache));
        log.info("动态规划解法:{}", dynamicPlan(15));

    }

    /**
     * 递归解法
     * 时间复杂度2^N
     * 空间复杂度2^N
     *
     * @param step
     * @return
     */
    private static int recursivePlan(int step) {


        return recursivePlan(step - 1) + recursivePlan(step - 2);
    }

    /**
     * 备忘录算法
     * 时间复杂度N
     * 空间复杂度N
     *
     * @param step
     * @param cache
     * @return
     */
    private static int recursiveCachePlan(int step, HashMap<Integer, Integer> cache) {
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        if (step < 1) {
            return 0;
        }
        if (cache.containsKey(step)) {
            return cache.get(step);
        } else {
            int value = recursiveCachePlan(step - 1, cache) + recursiveCachePlan(step - 2, cache);
            cache.put(step, value);
            return value;
        }
    }

    /**
     * 动态规划:找规律..
     * 时间复杂度N
     * 空间复杂度1
     *
     * @param step
     * @return
     */
    private static int dynamicPlan(int step) {
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        if (step < 1) {
            return 0;
        }
        //累加法
        int a = 1, b = 2, temp = 0;
        for (int i = 3; i <= step; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

}
