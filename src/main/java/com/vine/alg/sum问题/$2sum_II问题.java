package com.vine.alg.sum问题;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-03 4:46 PM
 */

public class $2sum_II问题 {

    public static void main(String[] args) {
        $2sum_II问题 sum = new $2sum_II问题();
        List<List<Integer>> lists = sum.twoSumTarget(new int[]{1, 3, 1, 2, 2, 3}, 4);
        System.out.println(JSON.toJSONString(lists));
    }

    /*
        nums中可能存在多对元素之和等于target， 请返回所有元素对，且不能重复出现
     */
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
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
        return res;
    }


}
