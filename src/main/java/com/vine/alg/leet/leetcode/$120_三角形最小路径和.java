package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-06-07 11:01 PM
 */

public class $120_三角形最小路径和 {

    /**
     * https://leetcode.cn/problems/triangle/
     * <p>
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
     * 示例 2：
     * <p>
     * 输入：triangle = [[-10]]
     * 输出：-10
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        $120_三角形最小路径和 z = new $120_三角形最小路径和();
        List<List<Integer>> lists = JSON.parseObject("[[2],[3,4],[6,5,7],[4,1,8,3]]", new TypeReference<List<List<Integer>>>() {
        });
        int i = z.minimumTotal(lists);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {


        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0) {
                    dp[i][j] = triangle.get(0).get(0);
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    int i1 = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    int i2 = dp[i - 1][j] + triangle.get(i).get(j);
                    dp[i][j] = Integer.min(i1, i2);
                }
            }
        }
        int[] ints = dp[triangle.size() - 1];
        return Arrays.stream(ints).min().getAsInt();
    }


}























