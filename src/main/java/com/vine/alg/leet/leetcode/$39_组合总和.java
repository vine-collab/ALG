package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-19 8:12 PM
 */

public class $39_组合总和 {


    /**
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
     * <p>
     * 示例1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * 示例2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        $39_组合总和 z = new $39_组合总和();
        List<List<Integer>> lists = z.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(JSON.toJSONString(lists));
    }

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<>());
        return res;

    }

    int sum = 0;

    void backtrack(int[] nums, int target, int pos, LinkedList<Integer> cur) {


        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            cur.addLast(nums[i]);
            sum += nums[i];
            backtrack(nums, target, i, cur);  // i保证能重复使用元素
            cur.removeLast();
            sum -= nums[i];
        }
    }


}

























