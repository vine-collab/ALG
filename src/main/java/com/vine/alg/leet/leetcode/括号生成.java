package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-04-21 8:59 PM
 */

public class 括号生成 {
    public static void main(String[] args) {
        括号生成 k = new 括号生成();
        List<String> strings = k.generateParenthesis(8);
        System.out.println(JSON.toJSONString(strings));

    }

    /*
    数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。


    示例 1：

    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：

    输入：n = 1
    输出：["()"]

    提示：

    1 <= n <= 8
     */

    public List<String> generateParenthesis(int n) {

        backtrack(n, "");
        return res;
    }

    List<String> res = new ArrayList<>();


    /*
        回溯解法
     */
    void backtrack(int n, String parentheses) {
        if (parentheses.length() == 2 * n) {
            // 判断括号成对
            if (check(parentheses)) {
                res.add(parentheses);
            }
            return;
        }

        // 选择列表
        backtrack(n, parentheses + ')');
        backtrack(n, parentheses + '(');


    }


    boolean check(String parentheses) {
        if (parentheses.length() == 0) {
            return true;
        }
        char[] chars = parentheses.toCharArray();

        if (chars[0] == ')' || chars[chars.length - 1] == '(') {
            return false;
        }
        // ["((()))","(()())","(())()","()(())","()()()"]
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[i + 1]) {
                return check(parentheses.substring(0, i) + parentheses.substring(i + 2));
            }
        }
        return false;
    }


}
