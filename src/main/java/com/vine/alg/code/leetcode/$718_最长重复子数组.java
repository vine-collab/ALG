package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-08-14 4:19 PM
 */

public class $718_最长重复子数组 {


    /**
     * 给两个整数数组nums1和nums2，返回 两个数组中 公共的 、长度最长的子数组的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
     * 输出：5
     * <p>
     * 链接：https://leetcode.cn/problems/maximum-length-of-repeated-subarray
     */
    public static void main(String[] args) {
        $718_最长重复子数组 z = new $718_最长重复子数组();
        int length = z.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        System.out.println(length);

    }


    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 令 dp[i][j] 表示 A[0...i - 1] 和 B[0...j - 1] 的最长公共前缀
        int[][] dp = new int[m + 1][n + 1];

        int res = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);

            }
        }

        return res;

    }

}



















































































