package com.vine.alg.backtrack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-04-06 8:44 PM
 */

public class N皇后问题 {


    public static void main(String[] args) {
        N皇后问题 n = new N皇后问题();

        int N = 4;
        List<List<String>> board = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(".");
            }
            board.add(row);
        }
        List<List<List<String>>> result = new ArrayList<>();

        n.solveNQueens(result, board, 0);

    }


    void solveNQueens(List<List<List<String>>> result, List<List<String>> board, int row) {
        try {
            if (row == board.size()) {
                // 注意list拷贝问题
                List<List<String>> lists = Lists.newArrayList(board);
                result.add(lists);
                lists.forEach(list -> System.out.println(JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect)));
                return;
            }

            // 棋盘的列数
            int n = board.get(row).size();
            for (int col = 0; col < n; col++) {
                if (!isValid(board, col, row)) {
                    continue;
                }
                List<String> rows = board.get(row);
                rows.set(col, "Q");
                solveNQueens(result, board, row + 1);
                rows.set(col, ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private boolean isValid(List<List<String>> board, int col, int row) {
        int n = board.size();
        // 同一行
        List<String> rows = board.get(row);
        if (rows.contains("Q")) {
            return false;
        }

        // 同一列
        for (int r = 0; r < row; r++) {
            if (board.get(r).get(col).equals("Q")) {
                return false;
            }
        }

        // 左上
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; c--, r--) {
            if (board.get(r).get(c).equals("Q")) {
                return false;
            }

        }


        // 右上
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board.get(r).get(c).equals("Q")) {
                return false;
            }
        }


        return true;
    }


}
























