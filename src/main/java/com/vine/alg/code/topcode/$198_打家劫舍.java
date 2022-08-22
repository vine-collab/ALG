package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-08-22 8:34 PM
 */

public class $198_打家劫舍 {


    public static void main(String[] args) {
        $198_打家劫舍 d = new $198_打家劫舍();
        int rob = d.rob(Utils.splitToIntArr1("1,2,3,1"));
        System.out.println(rob);
    }


    public int rob(int[] nums) {
        return rob(nums, 0);
    }



    Map<Integer, Integer> memo = new HashMap<>();


    /**
     * 表示从index 个屋子开始偷，能偷到最多的钱
     */
    int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if(memo.containsKey(index)) {
            return memo.get(index);
        }


        int res = 0;
        // 当前位置偷
        int cur = rob(nums, index + 2) + nums[index];
        // 档期位置不偷
        int rob = rob(nums, index + 1);
        res = Math.max(cur, rob);
        memo.put(index, res);
        return res;
    }


}































































