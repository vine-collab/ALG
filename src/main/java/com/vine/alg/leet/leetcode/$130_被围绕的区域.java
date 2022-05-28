package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-05-23 8:15 PM
 */

public class $130_被围绕的区域 {


    /**
     * 130. 被围绕的区域
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
     * 并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     * <p>
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     */

    public static void main(String[] args) {
        $130_被围绕的区域 b = new $130_被围绕的区域();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        b.solve(board);
        System.out.println(JSON.toJSONString(board));
    }


    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs1(board, 0, j, visited);
            }
            if (board[m - 1][j] == 'O') {
                dfs1(board, m - 1, j, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs1(board, i, 0, visited);
            }
            if (board[i][n - 1] == 'O') {
                dfs1(board, i, n - 1, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited);
                }
            }
        }


    }

    void dfs1(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }


        if (visited[i][j] || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
        }

        dfs1(board, i - 1, j, visited);
        dfs1(board, i + 1, j, visited);
        dfs1(board, i, j - 1, visited);
        dfs1(board, i, j + 1, visited);
    }


    void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }


        if (visited[i][j] || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'O' && !visited[i][j]) {
            board[i][j] = 'X';
            visited[i][j] = true;
        }

        dfs(board, i - 1, j, visited);
        dfs(board, i + 1, j, visited);
        dfs(board, i, j - 1, visited);
        dfs(board, i, j + 1, visited);
    }

}