package com.vine.alg.括号问题;

/**
 * @author 阿季
 * @date 2022-07-31 9:41 PM
 */

public class 平衡括号串2 {


    int minAddToMakeValid(String s) {
        int res = 0, need = 0; // need 右括号的需求量, res 插入的数量
        for (char c : s.toCharArray()) {
            if (c == '(') {
                need++;
                if (need % 2 == 1) { // 右括号必须是奇数，需要插入一个左括号
                    res++;
                }
            }

            if (c == ')') {
                need--;
                if (need < 0) {
                    res++;
                    need = 1;
                }
            }

        }
        return need + res;
    }

}































































