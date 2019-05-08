package me.datoucai.dynamic.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * 除数博弈[简单]
 * https://leetcode-cn.com/problems/divisor-game/
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 * @author cc
 * @date 2019/5/8
 */
@Slf4j
public class DynamicExample2 {
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
