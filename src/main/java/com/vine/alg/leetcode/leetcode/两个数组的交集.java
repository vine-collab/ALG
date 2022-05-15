package com.vine.alg.leetcode.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2021-06-03 20:24
 */

public class 两个数组的交集 {


    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] ints = set1.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    public static void main(String[] args) {


        两个数组的交集 c = new 两个数组的交集();
        int[] intersection = c.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(intersection);
    }


}
