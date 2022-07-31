package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-20 10:36 PM
 */

public class $79_单词搜索 {


    public static void main(String[] args) {
        $79_单词搜索 d = new $79_单词搜索();
        String s = "[[\"a\",\"b\"],[\"c\",\"d\"]]";
        List<List<String>> lists = JSON.parseObject(s, new TypeReference<List<List<String>>>() {
        });
        char[][] grid = new char[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                grid[i][j] = lists.get(i).get(j).charAt(0);
            }
        }
        boolean abcced = d.exist(grid, "abdc");
        System.out.println(abcced);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        this.word = word;
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, new StringBuilder(), used)) {
                        return true;
                    }

                }

            }
        }
        return false;
    }

    private String word;
    char[][] board;


    boolean backtrack(int i, int j, StringBuilder cur, boolean[][] used) {

        // 满足条件
        if (word.equals(cur.toString())) {
            return true;
        }

        if (word.length() < cur.length()) {
            return false;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (used[i][j]) {
            return false;
        }

        used[i][j] = true;
        cur.append(board[i][j]);
        if (backtrack(i, j + 1, cur, used)) {
            return true;
        }
        if (backtrack(i, j - 1, cur, used)) {
            return true;
        }
        if (backtrack(i - 1, j, cur, used)) {
            return true;
        }
        if (backtrack(i + 1, j, cur, used)) {
            return true;
        }

        used[i][j] = false;
        cur.deleteCharAt(cur.length() - 1);
        return false;
    }
}












