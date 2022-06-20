package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-20 10:36 PM
 */

public class $79_单词搜索 {

    public static void main(String[] args) {
        $79_单词搜索 d = new $79_单词搜索();
    }

    public boolean exist(char[][] board, String word) {



    }

    boolean res;

    boolean backtrack(char[][] board, String word, int i, int j, StringBuilder cur) {

        if(word.equals(cur.toString())) {
            return true;
        }

        if(word.length() < cur.length()) {
            return false;
        }


        for (int i1 = 0; i1 < board.length; i1++) {

        }




    }
}
