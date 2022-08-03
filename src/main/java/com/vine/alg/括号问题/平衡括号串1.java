package com.vine.alg.括号问题;

/**
 * @author 阿季
 * @date 2022-07-31 9:41 PM
 */

public class 平衡括号串1 {


    /**
     *
     * @param s
     * @return
     */
    int minAddToMakeValid(String s) {
        // res 记录需要插入左括号的插入次数
        int res = 0;
        // need 记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need++; // 对右括号的需求 + 1
            }


            if (s.charAt(i) == ')') {
                need--; // 对右括号的需求 - 1
                if (need == -1) {
                    need = 0;
                    // 需要插入一个左括号
                    res++;
                }
            }
        }

        return need + res;
    }

}































































