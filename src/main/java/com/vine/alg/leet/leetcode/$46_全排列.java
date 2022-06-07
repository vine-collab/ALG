package com.vine.alg.leet.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-06 8:46 PM
 */

public class $46_全排列 {


    /**
     * https://leetcode.cn/problems/permutations/
     */
    public static void main(String[] args) {
        $46_全排列 q = new $46_全排列();

    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList());
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.addLast(nums[i]);
            backtrack(nums, cur);
            cur.removeLast();
        }
    }

}
