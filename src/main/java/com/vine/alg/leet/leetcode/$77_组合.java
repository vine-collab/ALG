package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-06 8:22 PM
 */

public class $77_组合 {


    /**
     * https://leetcode.cn/problems/combinations/submissions/
     */

    public static void main(String[] args) {
        $77_组合 z = new $77_组合();
        List<List<Integer>> combine = z.combine(10, 7);
        System.out.println(JSON.toJSONString(combine));
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        backtrack(nums, 0, k, new LinkedList());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void backtrack(int[] nums, int start, int k, LinkedList<Integer> cur) {

        if(cur.size() > k ) {
            return;
        }

        if(cur.size() == k && !contains(cur)) {
            res.add(new ArrayList(cur));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(cur.contains(nums[i])) {
                continue;
            }
            cur.addLast(nums[i]);
            backtrack(nums, i + 1, k, cur);
            cur.removeLast();
        }


    }

    boolean contains( List<Integer> cur) {
        for(List<Integer> arr : res) {
            if(arr.containsAll(cur)) {
                return true;
            }
        }
        return false;
    }




}
