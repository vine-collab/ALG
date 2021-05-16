package com.hoteach.naive.动态规划;

/**
 * 编辑距离
 *
 * @author 阿季
 * @date 2021-05-16 16:34
 */

public class 编辑距离 {


    int miniDistance(String s, String t) {


        return dp(s, t, s.length() - 1, t.length() - 1);
    }


    int dp(String s, String t, int pointS, int pointT) {
        if (pointS == -1) return pointT + 1;
        if (pointT == -1) return pointS + 1;


        if (s.charAt(pointS) == t.charAt(pointT)) {
            return dp(s, t, pointS - 1, pointT - 1);
        } else {
            int insert = dp(s, t, pointS, pointT - 1) + 1;
            int delete = dp(s, t, pointS - 1, pointT) + 1;
            int replace = dp(s, t, pointS - 1, pointT - 1) + 1;
            return Math.min(insert, Math.min(delete, replace));

        }
    }


    public static void main(String[] args) {
        编辑距离 c = new 编辑距离();
        int i = c.miniDistance("apple", "plplea");
        System.out.println(i);
    }


}
