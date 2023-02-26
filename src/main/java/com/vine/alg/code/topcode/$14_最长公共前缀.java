package com.vine.alg.code.topcode;

/**
 * @author 阿季
 * @date 2022-08-17 8:52 PM
 */

public class $14_最长公共前缀 {

    public static void main(String[] args) {
        $14_最长公共前缀 z = new $14_最长公共前缀();
        String s = z.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].isEmpty()) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }
        }

        return strs[0];

    }


}































































