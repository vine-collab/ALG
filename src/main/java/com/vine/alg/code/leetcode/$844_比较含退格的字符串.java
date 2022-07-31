package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-05-09 9:58 PM
 */

public class $844_比较含退格的字符串 {


    /**
     * 844. 比较含退格的字符串
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：s 和 t 都会变成 "ac"。
     * 示例 2：
     * <p>
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 ""。
     * 示例 3：
     * <p>
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 "c"，但 t 仍然是 "b"。
     */
    public static void main(String[] args) {
        $844_比较含退格的字符串 b = new $844_比较含退格的字符串();
        boolean b1 = b.backspaceCompare("a##c", "#a#c");
        System.out.println(b1);

    }

    public boolean backspaceCompare(String s, String t) {
        String remove = remove(s);
        String remove1 = remove(t);
        return remove.equals(remove1);
    }


    public String remove(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int i = s.indexOf("#");
        if (i < 0) {
            return s;
        }
        if(i == 0) {
            return remove(s.substring(1));
        }
        String substring = s.substring(i - 1, i + 1);
        String replace = s.replace(substring, "");
        return remove(replace);

    }


}
