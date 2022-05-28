package com.vine.alg.leet.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-24 8:41 PM
 */

public class $797_所有可能的路径 {
    public static void main(String[] args) {
        $797_所有可能的路径 s = new $797_所有可能的路径();

    }


    /**
     * 797. 所有可能的路径
     * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
     *
     *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：graph = [[1,2],[3],[3],[]]
     * 输出：[[0,1,3],[0,2,3]]
     * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
     * 示例 2：
     *
     *
     *
     * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
     * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 从第0个节点开始遍历
        traverse(graph, 0, new LinkedList());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();


    void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 图的节点数
        int n = graph.length;

        // 到达终点
        if(s == n - 1) {
            path.addLast(s);
        }

        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        path.removeLast();


    }


}
