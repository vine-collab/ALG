package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2023-09-17 4:00 PM
 */

public class $1047_删除字符串中的所有相邻重复项 {


    /**
     * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * <p>
     * 示例：
     * <p>
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     */
    public static void main(String[] args) {
        $1047_删除字符串中的所有相邻重复项 z = new $1047_删除字符串中的所有相邻重复项();
        String baaa = z.removeDuplicates("abbaca");
        System.out.println(baaa);

    }

    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if(stk.isEmpty()) {
                stk.push(c);
            } else {
                if(stk.peek() == c) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }

        return stk.toString();
    }


    public String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(sb.length() == 0) {
                sb.append(c);
            } else {
                if(sb.charAt(sb.length() - 1) == c) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();





    }

}
















