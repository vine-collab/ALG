package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-19 4:32 PM
 */

public class $78_子集 {


    /**
     * https://leetcode.cn/problems/subsets/
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    public static void main(String[] args) {
        $78_子集 z = new $78_子集();
        List<List<Integer>> subsets = z.subsets(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(subsets));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }


    void backtrack(int[] nums, int pos, LinkedList<Integer> cur) {

        res.add(new ArrayList<>(cur));

        for (int i = pos; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.addLast(nums[i]);
            backtrack(nums, i + 1, cur);
            cur.removeLast();
        }


    }

    boolean contains(List<Integer> cur) {
        for (List<Integer> re : res) {
            if (re.size() != cur.size()) {
                continue;
            }
            return res.contains(cur);
        }
        return false;
    }


}
