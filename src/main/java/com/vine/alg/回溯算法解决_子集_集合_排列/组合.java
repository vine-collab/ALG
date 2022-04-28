package com.vine.alg.回溯算法解决_子集_集合_排列;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-04-28 9:03 AM
 */

public class 组合 {



    /*
        剑指 Offer II 080. 含有 k 个元素的组合
        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。



        示例 1:

        输入: n = 4, k = 2
        输出:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
        示例 2:

        输入: n = 1, k = 1
        输出: [[1]]
     */

    public static void main(String[] args) {
        组合 z = new 组合();
        List<List<Integer>> combine = z.combine(4, 2);
        System.out.println(JSON.toJSONString(combine));
    }


    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new ArrayList<>());
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();


    void backtrack(int n, int k, int pos, List<Integer> track) {

        if (track.size() == k) {
            ArrayList<Integer> integers = new ArrayList<>(track);
            res.add(integers);
            return;
        }

        for (int i = pos; i <= n; i++) {
            track.add(0, i);
            backtrack(n, k, i + 1, track);
            track.remove(0);
        }


    }


}
