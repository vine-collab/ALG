package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2023-09-16 11:37 PM
 */

public class $455_分发饼干 {


    public static void main(String[] args) {
        $455_分发饼干 z = new $455_分发饼干();
        int contentChildren = z.findContentChildren(Utils.splitToIntArr1("1,2"), Utils.splitToIntArr1("1,2,3"));
        System.out.println(contentChildren);
    }


    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if(res < g.length && g[res] <= s[i]) {
                res++;
            }
        }

        return res;


    }

}
