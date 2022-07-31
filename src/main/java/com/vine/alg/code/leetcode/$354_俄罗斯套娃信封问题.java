package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-14 10:52 PM
 */

public class $354_俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        $354_俄罗斯套娃信封问题 e = new $354_俄罗斯套娃信封问题();
        int i = e.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        System.out.println(i);
    }

    /**
     * https://leetcode.cn/problems/russian-doll-envelopes/
     * 354. 俄罗斯套娃信封问题
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     * <p>
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * <p>
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * <p>
     * 注意：不允许旋转信封。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出：3
     * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     * 示例 2：
     * <p>
     * 输入：envelopes = [[1,1],[1,1],[1,1]]
     * 输出：1
     */

    public int maxEnvelopes(int[][] envelopes) {
        System.out.println(JSON.toJSONString(envelopes));

        Arrays.sort(envelopes, (a, b) ->{
            return a[0] == b[0] ?
                    b[1] - a[1] : a[0] - b[0];
        } );
        System.out.println(JSON.toJSONString(envelopes));
        return 0;
    }

}
