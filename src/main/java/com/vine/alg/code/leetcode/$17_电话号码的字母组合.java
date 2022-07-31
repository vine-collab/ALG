package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-19 8:59 PM
 */

public class $17_电话号码的字母组合 {


    /**
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
     */
    public static void main(String[] args) {
        $17_电话号码的字母组合 d = new $17_电话号码的字母组合();
        List<String> strings = d.letterCombinations("23");
        System.out.println(JSON.toJSONString(strings));
    }


    // 每个数字到字母的映射
    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    // 回溯算法主函数
    void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }
        // 回溯算法框架
        for (int i = start; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            for (char c : mapping[digit].toCharArray()) {
                // 做选择
                sb.append(c);
                // 递归下一层回溯树
                backtrack(digits, i + 1, sb);
                // 撤销选择
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }



}

























