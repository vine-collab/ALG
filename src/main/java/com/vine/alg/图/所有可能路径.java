package com.vine.alg.图;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-13 9:02 PM
 */

public class 所有可能路径 {


    /**
     * https://leetcode.cn/problems/all-paths-from-source-to-target/
     */
    public static void main(String[] args) {
        所有可能路径 s = new 所有可能路径();
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = s.allPathsSourceTarget(graph);
        System.out.println(JSON.toJSONString(lists));
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 从第0个节点开始遍历
        traverse(graph, 0, new LinkedList());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void traverse(int[][] graph, int start, LinkedList<Integer> path) {

        // 图的顶点数
        int n = graph.length;

        path.addLast(start);

        if (start == n - 1) {
            res.add(new ArrayList<>(path));
        }

        for (int v : graph[start]) {
            traverse(graph, v, path);
        }

        path.removeLast();

    }


}
