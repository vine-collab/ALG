package com.vine.naive.leetcode;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * @author 阿季
 * @date 2022-04-21 8:50 AM
 */

public class 山羊拉丁文 {

    /*
    给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。

        请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：

        如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
        例如，单词 "apple" 变为 "applema" 。
        如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
        例如，单词 "goat" 变为 "oatgma" 。
        根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
        例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
        返回将 sentence 转换为山羊拉丁文后的句子。

        示例 1：

        输入：sentence = "I speak Goat Latin"
        输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        示例 2：

        输入：sentence = "The quick brown fox jumped over the lazy dog"
        输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     */


    public static void main(String[] args) {
        山羊拉丁文 s = new 山羊拉丁文();
        String i_speak_goat_latin = s.toGoatLatin("I speak Goat Latin");
        System.out.println(i_speak_goat_latin);
    }

    public String toGoatLatin(String sentence) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E','I','O','U');

        String res = "";
        String[] s = sentence.split(" ");
        int count = 1;
        for (String s1 : s) {
            String joint;
            if (list.contains(s1.charAt(0))) {
                joint = joint(s1, count);

            } else {
                String c = String.valueOf(s1.charAt(0));
                String substring = s1.substring(1) + c;
                joint = joint(substring, count);

            }
            res = res + " " + joint;
            count++;
        }
        return res.trim();

    }


    private String joint(String s, int count) {
        String last = s + "ma";
        for (int i = 0; i < count; i++) {
            last = last + "a";
        }
        return last;
    }
}


















