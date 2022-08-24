package com.vine.alg.sum问题;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-03 6:10 PM
 */

public class NSum问题 {
    public static void main(String[] args) {
        NSum问题 sum = new NSum问题();
        int[] ints = {1, 3, 1, 2, 2, 3};
        Arrays.sort(ints);
        List<List<Integer>> lists = sum.nSum(ints, 2, 4, 0);
        System.out.println(JSON.toJSONString(lists));
    }


    List<List<Integer>> nSum(int[] nums, int n, int target, int pos) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // base case
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            int left = pos, right = length - 1;
            while (left < right) {
                int l = nums[left];
                int r = nums[right];
                int sum = l + r;
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(l, r));
                    while (left < right && nums[left] == l) {
                        left++;
                    }
                    while (left < right && nums[right] == r) {
                        right--;
                    }
                }
            }
        } else {
            for (int i = pos; i < length; i++) {
                List<List<Integer>> lists = nSum(nums, n - 1, target - nums[i], i + 1);
                for (List<Integer> list : lists) {
                    List<Integer> copy = new ArrayList<>();
                    copy.add(nums[i]);
                    copy.addAll(list);
                    res.add(copy);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

}
