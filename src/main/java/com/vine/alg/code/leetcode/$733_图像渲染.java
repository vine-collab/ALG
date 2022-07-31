package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-06-03 3:56 PM
 */

public class $733_图像渲染 {


    /**
     * 733. 图像渲染
     *  https://leetcode.cn/problems/flood-fill/

     */
    public static void main(String[] args) {
        $733_图像渲染 x = new $733_图像渲染();
        int[][] ints = {{0, 0, 0}, {1, 0, 0}};
        int[][] ints1 = x.floodFill(ints, 1, 0, 2);
        System.out.println(JSON.toJSON(ints1));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void dfs(int[][] image, int i, int j, int seed, int newColor) {

        if (i < 0 || j < 0 || i >= image.length || j >= image[1].length) {
            return;
        }

        if (image[i][j] == newColor) {
            return;
        }

        if (image[i][j] != seed) {
            return;
        }

        image[i][j] = newColor;

        dfs(image, i - 1, j, seed, newColor);
        dfs(image, i + 1, j, seed, newColor);
        dfs(image, i, j - 1, seed, newColor);
        dfs(image, i, j + 1, seed, newColor);
    }


}
