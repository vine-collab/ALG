package com.vine.alg.回溯算法解决_子集_集合_排列;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 阿季
 * @date 2022-04-28 9:18 AM
 */

public class 排列 {
    /*
        46. 全排列
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        示例 1：
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        示例 2：
        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        示例 3：
        输入：nums = [1]
        输出：[[1]]
     */
    public static void main(String[] args) {
        排列 p = new 排列();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(permute));
    }


    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void backtrack(int[] nums, List<Integer> track) {
        if(track.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(track);
            res.add(copy);
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(0, num);
            backtrack(nums, track);
            track.remove(0);
        }

    }

}



















