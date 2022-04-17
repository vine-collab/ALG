package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-17 11:06 AM
 */

public class 高楼扔鸡蛋 {
    public static void main(String[] args) {
        try {
            高楼扔鸡蛋 b = new 高楼扔鸡蛋();
            int i = b.superEggDrop(5, 10);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
        k个鸡蛋，n层楼，最坏情况下，最少扔几次鸡蛋确定F楼层，0=<F<=n， 高于f的都会碎，低于f的不碎
        状态：鸡蛋碎不碎
        选择：去哪层楼扔鸡蛋
        出口：n = 0，不用扔；k == 1，挨个楼层去扔

     */
    int superEggDrop(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        // 从第一层开始
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

            // 最坏情况下，取两者最大 // 在第i楼扔了一次
            int maxi = Integer.max(superEggDrop(k - 1, i - 1), // 碎 从i下面楼层开始扔
                    superEggDrop(k, n - i) // 没碎 从i上面楼层开始扔
            ) + 1;

            // 最少扔鸡蛋次数
            res = Integer.min(res, maxi);
        }


        return res;
    }



}
