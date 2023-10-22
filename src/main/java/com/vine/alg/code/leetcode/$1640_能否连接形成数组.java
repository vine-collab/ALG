package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2023-10-23 11:12 PM
 */

public class $1640_能否连接形成数组 {


    /**
     * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
     * <p>
     * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：arr = [15,88], pieces = [[88],[15]]
     * 输出：true
     * 解释：依次连接 [15] 和 [88]
     * 示例 2：
     * 输入：arr = [49,18,16], pieces = [[16,18,49]]
     * 输出：false
     * 解释：即便数字相符，也不能重新排列 pieces[0]
     * 示例 3：
     * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
     * 输出：true
     * 解释：依次连接 [91]、[4,64] 和 [78]
     * https://leetcode.cn/problems/check-array-formation-through-concatenation/description/
     */
    public static void main(String[] args) {
        $1640_能否连接形成数组 z = new $1640_能否连接形成数组();
        int[] arr1 = Utils.splitToIntArr1("91,4,64,78");
        int[][] arr2 = Utils.toIntArr2("[[78],[4,64],[91]]");
        boolean b = z.canFormArray(arr1, arr2);
        System.out.println(b);
    }

    String s;

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            int num = arr[i];
            int[] ints = map.get(num);
            if (ints == null) {
                return false;
            }
            for (int j = 1; j < ints.length; j++) {
                if (ints[j] != arr[i]) {
                    break;
                }
                j++;
                i++;
            }
            i++;
        }

        return i == arr.length;
    }


}




















