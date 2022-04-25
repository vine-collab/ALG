package com.vine.naive.leetcode;

/**
 * @author 阿季
 * @date 2022-04-25 9:09 PM
 */

public class 跳跃游戏 {
    public static void main(String[] args) {
        跳跃游戏 t = new 跳跃游戏();
        boolean b = t.canJump(new int[]{2, 0});
        System.out.println(b);
    }

    /*
    给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。

    示例1：
    
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    示例2：
    
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     */

    public boolean canJump(int[] nums) {


        int length = nums.length;
        int pos = 0;

        for (int i = 0; i < length - 1; i++) {
            // 取跳的最远的
            pos = Integer.max(pos, i + nums[i]);
            // 遇到了0，跳不动了
            if (pos <= i) {
                return false;
            }
        }

        return pos >= length - 1;
    }

}
