package com.vine.alg.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 *
 * @author 阿季
 * @date 2021-04-22 15:14
 */

public class NQueens {


    private static List<List<String>> res = new ArrayList();


    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    List<List<String>> solveNQueens(int n) {
        // result用于存储答案
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    // search函数为搜索函数，n表示已经放置了n个皇后，cols 表示每个皇后所在的列
    private void search(List<List<String>> results, List<Integer> cols, int n) {
        // 若已经放置了n个皇后表示出现了一种解法，绘制后加入答案result
        if (cols.size() == n) {
            results.add(draw(cols));
            return;
        }
        // 枚举当前皇后放置的列，若不合法则跳过
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            // 若合法则递归枚举下一行的皇后
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    // isValid函数为合法性判断函数
    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            //若有其他皇后在同一列或同一斜线上则不合法
            if (cols.get(rowIndex) == col) {
                return false;
            }
            if (row + col == rowIndex + cols.get(rowIndex)) {
                return false;
            }
            if (row - col == rowIndex - cols.get(rowIndex)) {
                return false;
            }
        }
        return true;
    }

    // Draw函数为将 cols 数组转换为答案的绘制函数
    private List<String> draw(List<Integer> cols) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        // List<List<String>> lists = nQueens.solveNQueens(4);
        // lists.forEach(System.out::println);
        List<List<String>> boards = new ArrayList<>();
        List<String> row = Lists.newArrayList(".", ".", ".", ".");
        for (int j = 0; j < 4; j++) {
            boards.add(new ArrayList<>(row));
        }

        ArrayList<String> strings = new ArrayList<>(row);


        nQueens.nQueue(0, boards);
        System.out.println(JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect));

    }


    private static List<List<List<String>>> result = new ArrayList<>();

    /**
     * 路径：boards 中小于 row 的行都已经放置了皇后
     * 选择列表：第row行中所有的列都是放置皇后的选择
     * 结束条件：row和board的大小相等
     *
     * @param row    行数
     * @param boards 棋盘
     */
    public void nQueue(int row, List<List<String>> boards) {
        if (row == boards.size()) {

            String s = JSON.toJSONString(boards);
            List<List<String>> lists = JSON.parseObject(s, new TypeReference<List<List<String>>>() {
            });
            result.add(lists);
            return;
        }

        List<String> cols = boards.get(row);
        for (int col = 0; col < cols.size(); col++) {
            if (!check(boards, row, col)) {
                continue;
            }
            // 放置皇后
            for (int r = 0; r < boards.size(); r++) {
                if (r == row) {
                    List<String> cs = boards.get(r);
                    for (int c = 0; c < cs.size(); c++) {
                        if (c != col) {
                            continue;
                        }
                        cs.set(c, "q");
                    }
                }
            }
            // 递归下一行
            nQueue(row + 1, boards);

            // 撤销选择
            for (int r = 0; r < boards.size(); r++) {
                if (r == row) {
                    List<String> cs = boards.get(r);
                    for (int c = 0; c < cs.size(); c++) {
                        if (c != col) {
                            continue;
                        }
                        cs.set(c, ".");
                    }
                }
            }
        }
    }

    // 检测在[row][col]是否可以放置皇后
    private boolean check(List<List<String>> boards, int row, int col) {

        // 检查上方
        for (int r = 0; r < boards.size() && r <= row; r++) {
            List<String> cs = boards.get(r);
            for (int c = 0; c < cs.size(); c++) {
                if (c == col && cs.get(c).equals("q")) {
                    return false;
                }
            }
        }
        // 检测左上
        for (int r = 0; r < boards.size(); r++) {
            if (r != row - 1) continue;
            List<String> cs = boards.get(r);
            for (int c = 0; c < cs.size(); c++) {
                if (c == col - 1 && cs.get(c).equals("q")) {
                    return false;
                }
            }
        }
        // 检测右上
        for (int r = 0; r < boards.size(); r++) {
            if (r != row - 1) continue;
            List<String> cs = boards.get(r);
            for (int c = 0; c < cs.size(); c++) {
                if (c == col + 1 && cs.get(c).equals("q")) {
                    return false;
                }
            }
        }
        return true;
    }


}






































