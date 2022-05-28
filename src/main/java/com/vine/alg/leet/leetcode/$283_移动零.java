package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-05-28 4:36 PM
 */

public class $283_移动零 {


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * 链接：https://leetcode.cn/problems/move-zeroes
     */
    public static void main(String[] args) {
        $283_移动零 l = new $283_移动零();
        int[] ints = {0, 1, 0, 3, 12};
        l.moveZeroes(ints);
        System.out.println(JSON.toJSONString(ints));

    }

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 将 nums[p..] 的元素赋值为 0
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}




















