package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-05-21 3:28 PM
 */

public class $11_盛最多水的容器 {

    /**
     * 11. 盛最多水的容器
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     */
    public static void main(String[] args) {
        $11_盛最多水的容器 c = new $11_盛最多水的容器();
        int i = c.maxArea2(new int[]{1});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Integer.min(height[i], height[j]);
                res = Integer.max(res, area);
            }
        }
        return res;
    }




    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            int area = Integer.min(height[left], height[right]) * (right - left);
            res = Integer.max(area, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;

    }


}



















