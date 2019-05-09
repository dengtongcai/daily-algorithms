package me.datoucai.dynamic.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * 爬楼梯[简单]
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 * <p>
 * 比如，每次走1级台阶，一共走10步，这是其中一种走法。我们可以简写成 1,1,1,1,1,1,1,1,1,1。
 *
 * @author cc
 * @date 2019/5/8
 */
@Slf4j
public class DynamicExample1 {
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
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        if (step < 1) {
            return 0;
        }
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
