package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-05-15 5:15 PM
 */

public class $986_区间列表的交集 {

    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
     * <p>
     * 返回这 两个区间列表的交集 。
     * <p>
     * 形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
     * <p>
     * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * 示例 2：
     * <p>
     * 输入：firstList = [[1,3],[5,9]], secondList = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：firstList = [], secondList = [[4,8],[10,12]]
     * 输出：[]
     * 示例 4：
     * <p>
     * 输入：firstList = [[1,7]], secondList = [[3,10]]
     * 输出：[[3,7]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/interval-list-intersections
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        $986_区间列表的交集 q = new $986_区间列表的交集();
        int[][] ints = q.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        System.out.println(JSON.toJSONString(ints));

    }


    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<List<Integer>> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            if (!(a1 > b2 || b1 > a2)) {
                res.add(Arrays.asList(Integer.max(a1, b1), Integer.min(a2, b2)));
            }
            if (a2 > b2) {
                j++;
            } else {
                i++;
            }
        }
        int[][] ints = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            int[] ints1 = {res.get(k).get(0), res.get(k).get(1)};
            ints[k] = ints1;
        }
        return ints;


    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            int[] first = firstList[i];
            for (int j = 0; j < secondList.length; j++) {
                int[] second = secondList[j];
                int[] intersection = intersection(first, second);
                if (intersection != null) {
                    List<Integer> collect = Arrays.stream(intersection).boxed().collect(Collectors.toList());
                    res.add(collect);
                }
            }
        }

        int[][] ints = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] ints1 = {res.get(i).get(0), res.get(i).get(1)};
            ints[i] = ints1;
        }
        return ints;
    }

    /**
     * 没有交集返回null
     *
     * @param a
     * @param b
     * @return
     */
    public int[] intersection(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return null;
        }
        if (a[0] > b[1] || b[0] > a[1]) {
            return null;
        } else {
            return new int[]{Integer.max(a[0], b[0]), Integer.min(a[1], b[1])};
        }

    }

}


















