package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-08-14 3:52 PM
 */

public class $169_多数元素 {


    /**
     * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例2：
     * <p>
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * 链接：https://leetcode.cn/problems/majority-element
     */
    public static void main(String[] args) {
        $169_多数元素 d = new $169_多数元素();
        int i = d.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }


    public int majorityElement(int[] nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
}































































