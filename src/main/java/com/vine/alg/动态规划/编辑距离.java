package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-15 8:52 AM
 */

public class 编辑距离 {


    public static void main(String[] args) {
        try {
            编辑距离 b = new 编辑距离();
            String s1 = "intention", s2 = "execution";
            int i = b.minDistance(s1, s2, s1.length() - 1, s2.length() - 1);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        pos1 和 pos2 的最短距离是minDistance
     */
    int minDistance(String s1, String s2, int pos1, int pos2) {

        if (pos1 == -1) {
            return pos2 + 1;
        }
        if (pos2 == -1) {
            return pos1 + 1;
        }

        if (s1.charAt(pos1) == s2.charAt(pos2)) {
            return this.minDistance(s1, s2, pos1 - 1, pos2 - 1);
        }

        if (s1.charAt(pos1) != s2.charAt(pos2)) {
            return Math.min(minDistance(s1, s2, pos1 - 1, pos2) + 1,
                    Math.min(minDistance(s1, s2, pos1, pos2 - 1) + 1,
                            minDistance(s1, s2, pos1 - 1, pos2 - 1) + 1
                    ));
        }


        return 0;
    }


}
