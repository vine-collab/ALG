package com.vine.alg.leet.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-25 8:19 PM
 */

public class $40_组合总和II {


    /**
     * https://leetcode.cn/problems/combination-sum-ii/
     *
     *40. 组合总和 II
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。
     *
     *
     *
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     */
    public static void main(String[] args) {
        $40_组合总和II z = new $40_组合总和II();

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new LinkedList<Integer>(), 0, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void backtrack(int[] candidates, int target, LinkedList<Integer> cur, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList(cur));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            cur.addLast(candidates[i]);
            backtrack(candidates, target, cur, i + 1, sum);
            cur.removeLast();
            sum -= candidates[i];


        }


    }


}
