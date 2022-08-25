package com.vine.alg.code.topcode;

import com.alibaba.fastjson.JSON;
import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2022-08-24 9:28 PM
 */

public class $283_移动零 {

    public static void main(String[] args) {
        $283_移动零 y = new $283_移动零();
        int[] nums = Utils.splitToIntArr1("0,1,0,3,12");
        y.moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));

    }

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}































































