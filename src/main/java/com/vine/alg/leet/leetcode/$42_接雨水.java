package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-07-24 6:08 PM
 */

public class $42_接雨水 {


    /**
     * https://leetcode.cn/problems/trapping-rain-water/
     */
    public static void main(String[] args) {
        $42_接雨水 j = new $42_接雨水();
        int trap = j.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;
            // 找右边最高的柱子
            for (int j = i; j < n; j++)
                r_max = Math.max(r_max, height[j]);
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--)
                l_max = Math.max(l_max, height[j]);
            // 如果自己就是最高的话，
            // l_max == r_max == height[i]
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }


    public int trapMemo(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        // 计算左侧最大值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Integer.max(height[i], leftMax[i - 1]);
        }
        // 计算右侧最大值
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Integer.max(rightMax[j + 1], height[j]);
        }

        for (int i = 1; i < n; i++) {
            res += Integer.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;

    }


    public int trap2(int[] height) {
        int maxL = 0, maxR = 0;
        int left = 0, right = height.length - 1;
        int res = 0;
        while(left <= right) {
            maxL = Integer.max(maxL, height[left]);
            maxR = Integer.max(maxR, height[right]);

            if(maxL < maxR) {
                res += (maxL - height[left]);
                left++;
            } else {
                res += (maxR - height[right]);
                right--;
            }

        }
        return res;
    }
}































































