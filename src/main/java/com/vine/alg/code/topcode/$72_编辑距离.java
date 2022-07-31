package com.vine.alg.code.topcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-07-31 2:59 PM
 */

public class $72_编辑距离 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        $72_编辑距离 b = new $72_编辑距离();
        int i = b.minDistance("horse", "ros");
        System.out.println(i);


    }

    public int minDistance(String word1, String word2) {
        return minDistanceMemo(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    Map<String, Integer> memo = new HashMap<>();


    /**
     * 表示s1[0, i]-> s2[0, j] 的最短距离
     * base case
     * i = -1, or j = -1
     * <p>
     * distance = min{插入，删除，替换}
     */
    public int minDistanceMemo(String s1, int p1, String s2, int p2) {

        if (p1 < 0) {
            return p2 + 1;
        }

        if (p2 < 0) {
            return p1 + 1;
        }

        String key = getKey(p1, p2);
        Integer v = memo.get(key);
        if (v != null) {
            return v;
        }
        int res;

        if (s1.charAt(p1) == s2.charAt(p2)) {
            res = minDistanceMemo(s1, p1 - 1, s2, p2 - 1);
        } else {
            // 插入
            int insert = minDistanceMemo(s1, p1, s2, p2 - 1);
            // 删除
            int delete = minDistanceMemo(s1, p1 - 1, s2, p2);
            // 替换
            int replace = minDistanceMemo(s1, p1 - 1, s2, p2 - 1);
            res = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        memo.put(key, res);
        return res;

    }

    String getKey(int i, int j) {
        return i + "_" + j;
    }


}































































