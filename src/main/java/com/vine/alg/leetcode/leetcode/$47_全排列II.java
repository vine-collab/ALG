package com.vine.alg.leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-25 10:14 PM
 */

public class $47_全排列II {


    /**
     * https://leetcode.cn/problems/permutations-ii/
     * <p>
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        $47_全排列II q = new $47_全排列II();
        List<List<Integer>> list = q.permuteUnique(new int[]{1, 1, 2});
        System.out.println(JSON.toJSONString(list));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new LinkedList(), used);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();


    void backtrack(int[] nums, LinkedList<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            cur.addLast(nums[i]);
            backtrack(nums, cur, used);
            cur.removeLast();
            used[i] = false;
        }


    }


}
