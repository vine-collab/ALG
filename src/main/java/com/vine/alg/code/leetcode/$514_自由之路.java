package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author 阿季
 * @date 2023-04-08 3:25 PM
 */

public class $514_自由之路 {


    /**
     * 输入: ring = "godding", key = "gd"
     * 输出: 4
     * 解释:
     * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
     * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
     * 当然, 我们还需要1步进行拼写。
     * 因此最终的输出是 4。
     * 示例 2:
     * <p>
     * 输入: ring = "godding", key = "godding"
     * 输出: 13
     * <p>
     * https://leetcode.cn/problems/freedom-trail/
     */
    public static void main(String[] args) {
        $514_自由之路 z = new $514_自由之路();

        int rotateSteps = z.findRotateSteps("godding", "godding");
        System.out.println(rotateSteps);
    }

    int[][] memo;
    Map<Character, LinkedList<Integer>> charToIdx = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        for (int i = 0; i < rings.length; i++) {
            if (!charToIdx.containsKey(rings[i])) {
                charToIdx.put(rings[i], new LinkedList<>());
            }
            charToIdx.get(rings[i]).add(i);

        }

        memo = new int[rings.length][keys.length];
        return dp(rings, 0, keys, 0);

    }

    // dp(i,j) 当指针指向 ring[i]时, 输入key[j...] 至少需要dp次操作
    int dp(char[] ring, int i, char[] key, int j) {
        if (j == key.length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;
        // ring 上可能有多个字符 key[j]
        for (int k : charToIdx.get(key[j])) {
            // 拨动指针的次数
            int offset = Math.abs(i - k);
            // 选择顺时针还是逆时针
            offset = Math.min(offset, ring.length - offset);

            int sub = dp(ring, k, key, j + 1);

            res = Math.min(res, 1 + offset + sub);

        }
        // 将结果存入备忘录
        memo[i][j] = res;
        return res;

    }


}































































