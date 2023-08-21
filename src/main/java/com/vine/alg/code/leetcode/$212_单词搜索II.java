package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2023-08-20 15:11
 */

public class $212_单词搜索II {

    public static void main(String[] args) {
        $212_单词搜索II z = new $212_单词搜索II();
        char[][] board = new char[][]{{'a'},{'a'}};
        List<String> words = z.findWords(board, new String[]{"aa"});
        System.out.println(JSON.toJSONString(words));
    }


    /**
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
     * 输出：["eat","oath"]
     * 示例 2：
     * <p>
     * <p>
     * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
     * <p>
     * 输出：[]
     * <p>
     * https://leetcode.cn/problems/word-search-ii/description/
     */
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board.length;
        this.set = Arrays.stream(words).collect(Collectors.toSet());
        List<String> res = new ArrayList<>();
        for(String s : words) {
            this.word = s;
            boolean[][] used = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == s.charAt(0)) {
                        if(dfs(i, j, 0, used)) {
                            res.add(s);
                        }
                    }
                }
            }
        }
        return res;
    }
    Set<String> set;
    int m;
    int n;
    char[][] board;
    String word;

    boolean dfs(int i, int j, int p, boolean[][] used) {
        if(word.length() == p) {
            return set.remove(word);

        }

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if(used[i][j]) {
            return false;
        }

        if(word.charAt(p) != board[i][j]) {
            return false;
        }

        used[i][j] = true;
        if(dfs(i - 1, j, p + 1, used)) {
            return true;
        }

        if(dfs(i + 1, j, p + 1, used)) {
            return true;
        }

        if(dfs(i, j - 1, p + 1, used)) {
            return true;
        }

        if(dfs(i, j + 1, p + 1, used)) {
            return true;
        }

        used[i][j] = false;
        return false;

    }






}































































