package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2021-06-04 17:04
 */

public class 编辑距离 {
    public int minDistance(String word1, String word2, int point1, int point2) {

        if (point1 == -1) {
            return point2 + 1;
        }
        if (point2 == -1) {
            return point1 + 1;
        }

        if (word1.charAt(point1) == word2.charAt(point2)) {
            return minDistance(word1, word2, point1 - 1, point2 - 1);
        } else {
            // 插入
            int insert = minDistance(word1, word2, point1, point2 - 1) + 1;
            // 删除
            int delete = minDistance(word1, word2, point1 - 1, point2) + 1;
            // 交换
            int replace = minDistance(word1, word2, point1 - 1, point2 - 1) + 1;
            return Math.min(Math.min(insert, delete), replace);
        }

    }


    public static void main(String[] args) {
        编辑距离 c = new 编辑距离();
        String s = "horse";
        String t = "ros";
        int i = c.minDistance(s, t, s.length() - 1, t.length() - 1);
        System.out.println(i);
    }

}
