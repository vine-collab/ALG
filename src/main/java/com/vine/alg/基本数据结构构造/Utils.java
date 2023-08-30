package com.vine.alg.基本数据结构构造;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-08-16 9:49 PM
 */

public class Utils {


    public static int[] toIntArr1(String star) {
        List<Integer> lists = JSON.parseObject(star, new TypeReference<List<Integer>>() {
        });
        return lists.stream().mapToInt(Integer::intValue).toArray();

    }

    public static ListNode splitToListNode(String str) {
        List<Integer> list = Arrays.stream(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return ListNode.createListNode(list);
    }


    public static int[]  splitToIntArr1(String star) {
        return Arrays.stream(star.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static int[][] toIntArr2(String star) {
        List<List<Integer>> lists = JSON.parseObject(star, new TypeReference<List<List<Integer>>>() {
        });

        int[][] ints = new int[lists.size()][];

        for (int i = 0; i < lists.size(); i++) {
            ints[i] = lists.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ints;

    }

    public static void printf(Object o) {
        System.out.println(JSON.toJSONString(o));
    }


}































































