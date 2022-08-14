package com.vine.alg.code.topcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-13 3:10 PM
 */

public class $78_子集 {

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


    void backtrack(int[] nums, int index, LinkedList<Integer> cur) {
        res.add(new ArrayList<>(cur));

        for(int i = index; i < nums.length; i++) {
            if(cur.contains(nums[i])) {
                continue;
            }
            cur.addLast(nums[i]);
            backtrack(nums, index + 1, cur);
            cur.removeLast();


        }
    }
}































































