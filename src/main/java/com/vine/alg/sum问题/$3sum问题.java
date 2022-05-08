package com.vine.alg.sum问题;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-03 5:45 PM
 */

public class $3sum问题 {


    /*
        给定数组nums，判断是否存在三元组，a，b，c，的和为target，输出不重复的三元组
     */
    public static void main(String[] args) {
        $3sum问题 sum = new $3sum问题();

        List<List<Integer>> lists = sum.threeSum(new int[]{-1, 0, 1, 2, 0, -1, -4}, 0);
        System.out.println(JSON.toJSONString(lists));
    }

    List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists = twoSum(nums, target - nums[i], i + 1);
            for (List<Integer> list : lists) {
                List<Integer> copy = new ArrayList<>();
                copy.add(nums[i]);
                copy.addAll(list);
                res.add(copy);
            }
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int target, int pos) {
        int left = pos, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int l = nums[left];
            int r = nums[right];
            int sum = l + r;
            if (sum > target) {
                while (left < right && nums[right] == r) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == l) {
                    left++;
                }
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




























