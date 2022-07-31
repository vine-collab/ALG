package com.vine.alg.code.动态规划;

/**
 * @author 阿季
 * @date 2021-05-22 15:50
 */

public class 跳跃游戏 {

    boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            int current = i + nums[i];
            farthest = Math.max(farthest, current);
            // 可能碰到了 0，卡住跳不动了
            if (farthest <= i) return false;
        }
        return farthest >= n - 1;
    }


    int canJump2(int[] nums) {
        int dp = dp(nums, 0);

        return dp;
    }


    /**
     * dp:从索引p的位置跳跃到最后至少需要dp(nums, p)次
     *
     * @param nums
     * @param p
     * @return
     */
    int dp(int[] nums, int p) {
        // 位置超过末尾不需要跳了
        if (p >= nums.length - 1) {
            return 0;
        }
        int steps = nums[p];
        int result = nums.length;
        for (int i = 1; i <= steps; i++) {
            int dp = dp(nums, p + i);
            result = Math.min(dp + 1, result);
        }


        return result;
    }

    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    int canJump22(int[] nums) {
        int result = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(nums[i] + i, farthest);

        }
        return 0;
    }

    int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = nums[i] + i;
            farthest = Math.max(temp, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }


    public static void main(String[] args) {
        跳跃游戏 c = new 跳跃游戏();
        //2, 3, 1, 1, 4
        boolean b = c.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
        long l = System.currentTimeMillis();
        int i = c.canJump2(new int[]{2, 3, 1, 1, 4});
        System.out.println(i);
        int j = c.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(j);



    }


}
