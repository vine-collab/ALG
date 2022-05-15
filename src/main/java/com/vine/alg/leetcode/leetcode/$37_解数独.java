package com.vine.alg.leetcode.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-02 8:45 PM
 */

public class $37_解数独 {
    /*
    37. 解数独
    编写一个程序，通过填充空格来解决数独问题。

    数独的解法需 遵循如下规则：

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    数独部分空格内已填入了数字，空白格用 '.' 表示。

    示例 1：

    输入：board = [   ["5","3",".",".","7",".",".",".","."]
                    ,["6",".",".","1","9","5",".",".","."]
                    ,[".","9","8",".",".",".",".","6","."]
                    ,["8",".",".",".","6",".",".",".","3"]
                    ,["4",".",".","8",".","3",".",".","1"]
                    ,["7",".",".",".","2",".",".",".","6"]
                    ,[".","6",".",".",".",".","2","8","."]
                    ,[".",".",".","4","1","9",".",".","5"]
                    ,[".",".",".",".","8",".",".","7","9"]]

    输出：[   ["5","3","4","6","7","8","9","1","2"]
            ,["6","7","2","1","9","5","3","4","8"]
            ,["1","9","8","3","4","2","5","6","7"]
            ,["8","5","9","7","6","1","4","2","3"]
            ,["4","2","6","8","5","3","7","9","1"]
            ,["7","1","3","9","2","4","8","5","6"]
            ,["9","6","1","5","3","7","2","8","4"]
            ,["2","8","7","4","1","9","6","3","5"]
            ,["3","4","5","2","8","6","1","7","9"]]
    解释：输入的数独如上图所示，唯一有效的解决方案如下所示：

     */

    public static void main(String[] args) {
        $37_解数独 j = new $37_解数独();

        List<List<String>> lists = JSON.parseObject("[   [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]", new TypeReference<List<List<String>>>() {
        });

        char[][] chars = new char[lists.size()][lists.size()];

        for (int i = 0; i < lists.size(); i++) {
            List<String> strings = lists.get(i);
            for (int k = 0; k < strings.size(); k++) {
                chars[i][k] = strings.get(k).charAt(0);
            }
        }
        j.solveSudoku(chars);
//        System.out.println(JSON.toJSONString(chars));
    }


    char[][] res = new char[9][9];


    public void solveSudoku(char[][] chars) {
        backtrack(chars, 0, 0);
        chars = res;
        boolean b = backtrack1(chars, 0, 0);
        System.out.println(b);
    }


    public void backtrack(char[][] board, int row, int column) {

        int length = board.length;

        // 一行已经扫描完了，从下一行开始
        if (length == column) {
            backtrack(board, row + 1, 0);
            return;
        }

        if (row == length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    res[i][j] = board[i][j];
                }
            }
            return;
        }

        if (board[row][column] != '.') {
            backtrack(board, row, column + 1);
            return;
        }


        // 选择 1~9
        for (char i = '1'; i <= '9'; i++) {
            // 做选择

            if (!isValid(board, row, column, i)) {
                continue;
            }

            board[row][column] = i;
            backtrack(board, row, column + 1);
            board[row][column] = '.';

        }
    }


    // 判断board[r][j]位置是否能填入数字n
    boolean isValid(char[][] board, int r, int c, char n) {
        for (int j = 0; j < board.length; j++) {
            if (board[r][j] == n) {
                return false;
            }
            if (board[j][c] == n) {
                return false;
            }
            // 判断3*3 有没有重复
            char ch = board[(r / 3) * 3 + j / 3][(c / 3) * 3 + j % 3];
            if (ch == n) {
                return false;
            }

        }


        return true;
    }


    boolean backtrack1(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack1(board, i + 1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != '.') {
            // 如果有预设数字，不用我们穷举
            return backtrack1(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack1(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }


}
