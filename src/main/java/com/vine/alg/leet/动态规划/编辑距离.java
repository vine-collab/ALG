package com.vine.alg.leet.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * 编辑距离
 *
 * @author 阿季
 * @date 2021-05-16 16:34
 */

public class 编辑距离 {


    Map<String, Integer> memory = new HashMap<>();


    int miniDistance(String s, String t, int pointS, int pointT) {
        Integer integer = memory.get(pointS + "_" + pointT);
        if(memory.get(pointS + "_" + pointT) != null) {
            return integer;
        }

        if (pointS == -1) return pointT + 1;
        if (pointT == -1) return pointS + 1;


        if (s.charAt(pointS) == t.charAt(pointT)) {
            int i = miniDistance(s, t, pointS - 1, pointT - 1);
            memory.put(pointS + "_" + pointT, i);
            return i;
        } else {
            int insert = miniDistance(s, t, pointS, pointT - 1) + 1;
            int delete = miniDistance(s, t, pointS - 1, pointT) + 1;
            int replace = miniDistance(s, t, pointS - 1, pointT - 1) + 1;
            int min = Math.min(insert, Math.min(delete, replace));
            memory.put(pointS + "_" + pointT, min);
            return min;

        }
    }


    public static void main(String[] args) {
        编辑距离 c = new 编辑距离();
        String s = "apple";
        String t = "peplee";
        int i = c.miniDistance(s, t, s.length() - 1, t.length() - 1);
        System.out.println(i);
    }


}
