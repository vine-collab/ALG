package com.vine.alg.leet.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 阿季
 * @date 2022-06-28 8:24 PM
 */

public class $202_快乐数 {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * <p>
     * 「快乐数」定义为：
     * <p>
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * <p>
     * 链接：https://leetcode.cn/problems/happy-number
     */
    public static void main(String[] args) {
        $202_快乐数 k = new $202_快乐数();
        boolean happy = k.isHappy(19);
        System.out.println(happy);
    }


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
             n = sum(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;

    }


    int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }


}














