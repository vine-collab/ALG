package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 阿季
 * @date 2022-06-28 8:44 AM
 */

public class $384_打乱数组 {
    public static void main(String[] args) {
        $384_打乱数组 d = new $384_打乱数组();
        int[] shuffle = d.shuffle(new int[]{1, 3, 5, 7, 9});
        System.out.println(JSON.toJSONString(shuffle));
    }

    int[] shuffle(int[] arr) {
        int n = arr.length; // 5
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int rand = random.nextInt(n);
            System.out.println(rand);
            int t = arr[rand];
            arr[rand] = arr[i];
            arr[i] = t;
        }
        return arr;
    }

}

