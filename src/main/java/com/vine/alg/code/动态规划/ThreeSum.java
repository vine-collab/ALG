package com.vine.alg.code.动态规划;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2021-05-19 17:26
 */

public class ThreeSum {
    public List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (n < 2 || length < n) {
            return result;
        }

        if (n == 2) {
            int leftPoint = start;
            int rightPoint = nums.length - 1;
            while (leftPoint < rightPoint) {
                int left = nums[leftPoint];
                int right = nums[rightPoint];
                int sum = left + right;
                if (sum == target) {
                    List<Integer> integers = Arrays.asList(left, right);
                    result.add(new ArrayList<>(integers));
                    while (leftPoint < rightPoint && nums[leftPoint] == left) {
                        leftPoint++;
                    }
                    while (leftPoint < rightPoint && nums[rightPoint] == right) {
                        rightPoint--;
                    }
                }

                if (sum > target) {
                    while (leftPoint < rightPoint && nums[rightPoint] == right) {
                        rightPoint--;
                    }
                }

                if (sum < target) {
                    while (leftPoint < rightPoint && nums[leftPoint] == left) {
                        leftPoint++;
                    }
                }
            }
        }

        if (n > 2) {
            for (int i = start; i < nums.length; i++) {
                int first = nums[i];
                List<List<Integer>> lists = nSum(nums, target - nums[i], n - 1, i + 1);
                if (lists != null && !lists.isEmpty()) {
                    lists.forEach(list -> list.add(0, first));
                    result.addAll(lists);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> lists = threeSum.nSum(nums, 0, 3, 0);
        System.out.println(JSON.toJSONString(lists));
    }

}
