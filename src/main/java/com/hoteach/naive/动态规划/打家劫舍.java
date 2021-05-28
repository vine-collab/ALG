package com.hoteach.naive.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2021-05-28 17:23
 */

public class 打家劫舍 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        return funRob(nums, 0);
    }

    public int funRob(int[] nums, int start) {
        Integer integer = map.get(start);
        if(integer != null) {
            return integer;
        }
        if (start >= nums.length) {
            return 0;
        }

        int max = Math.max(funRob(nums, start + 1), funRob(nums, start + 2) + nums[start]);
        map.put(start, max);
        return max;

    }


    public static void main(String[] args) {
        打家劫舍 c = new 打家劫舍();
        int rob = c.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);

    }

}
