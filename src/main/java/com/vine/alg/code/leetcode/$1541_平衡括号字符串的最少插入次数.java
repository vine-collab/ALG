package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-03 9:11 PM
 */

public class $1541_平衡括号字符串的最少插入次数 {


    /**
     * 给你一个括号字符串s，它只包含字符'(' 和')'。一个括号字符串被称为平衡的当它满足：
     * <p>
     * 任何左括号'('必须对应两个连续的右括号'))'。
     * 左括号'('必须在对应的连续两个右括号'))'之前。
     * 比方说"())"，"())(())))" 和"(())())))"都是平衡的，")()"，"()))" 和"(()))"都是不平衡的。
     * <p>
     * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
     * <p>
     * 请你返回让 s平衡的最少插入次数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()))"
     * 输出：1
     * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
     * 示例 2：
     * <p>
     * 输入：s = "())"
     * 输出：0
     * 解释：字符串已经平衡了。
     * <p>
     * 链接：https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string
     */
    public static void main(String[] args) {
        $1541_平衡括号字符串的最少插入次数 z = new $1541_平衡括号字符串的最少插入次数();
        int i = z.minInsertions("(()))");
        System.out.println(i);
    }


    public int minInsertions(String s) {
        int res = 0, need = 0; // res需要插入的括号数， need 需要配对的右括号数

        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2; // 一个左括号要两个右括号配对
                if (need % 2 == 1) {
                    res++; // 插入一个右括号
                    need--; // 右括号需求减一个；
                }
            } else {
                need--;
                if (need < 0) {
                    res++; // 需要插入一个左括号
                    need = 1; // 再需要插入一个有扩号才能平恒
                }
            }
        }

        return res + need;

    }


}































































