package com.vine.alg.code.topcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-14 7:38 PM
 */

public class $39_组合总和 {

    public static void main(String[] args) {
        $39_组合总和 z = new $39_组合总和();
        List<List<Integer>> lists = z.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(target, 0, new LinkedList<>());
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();

    int[] candidates;

    void backtrack(int target, int index, LinkedList<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            cur.addLast(candidates[i]);
            backtrack(target - candidates[i], i, cur);
            cur.removeLast();
        }
    }


}































































