package com.hoteach.naive;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nsum问题
 *
 * @author 阿季
 * @date 2021-05-12 15:37
 */

public class NSum {


    public int[] twoSum(int[] nums, Integer target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum > target) {
                right--;
            }

            if (sum < target) {
                left++;
            }
        }
        return new int[]{};
    }

    public List<List<Integer>> twoSums(int[] nums, Integer target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int pointLeft = 0;
        int pointRight = nums.length - 1;

        while (pointLeft < pointRight) {
            int left = nums[pointLeft];
            int right = nums[pointRight];
            int sum = nums[pointLeft] + nums[pointRight];
            if (sum == target) {
                result.add(Lists.newArrayList(nums[pointLeft], nums[pointRight]));
                while (pointLeft < pointRight && nums[pointLeft] == left) {
                    pointLeft++;
                }
                while (pointLeft < pointRight && nums[pointRight] == right) {
                    pointRight--;
                }
            }
            if (sum > target) {
                pointRight--;
            }

            if (sum < target) {
                pointLeft++;
            }
        }
        return result;
    }

    public List<List<Integer>> twoSums(int[] nums, int start, Integer target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int pointLeft = start;
        int pointRight = nums.length - 1;

        while (pointLeft < pointRight) {
            int left = nums[pointLeft];
            int right = nums[pointRight];
            int sum = nums[pointLeft] + nums[pointRight];
            if (sum == target) {
                result.add(Lists.newArrayList(nums[pointLeft], nums[pointRight]));
                while (pointLeft < pointRight && nums[pointLeft] == left) {
                    pointLeft++;
                }
                while (pointLeft < pointRight && nums[pointRight] == right) {
                    pointRight--;
                }
            }
            if (sum > target) {
                pointRight--;
            }

            if (sum < target) {
                pointLeft++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSums(int[] nums, Integer target) {

        Arrays.sort(nums);
        System.out.println(JSON.toJSONString(nums));
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            List<List<Integer>> lists = twoSums(nums, i + 1, target - nums[i]);
            if (CollectionUtils.isNotEmpty(lists)) {
                lists.forEach(list -> list.add(0, first));
                result.addAll(lists);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }


    public List<List<Integer>> nSums(int[] nums, int n, int start, Integer target) {
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
                if (target == sum) {
                    result.add(Lists.newArrayList(left, right));
                    while (leftPoint < rightPoint && nums[leftPoint] == left) {
                        leftPoint++;
                    }
                    while (leftPoint < rightPoint && nums[rightPoint] == right) {
                        rightPoint--;
                    }
                }
                if (target < sum) {
                    while (leftPoint < rightPoint && nums[rightPoint] == right) {
                        rightPoint--;
                    }
                }

                if (target > sum) {
                    while (leftPoint < rightPoint && nums[leftPoint] == left) {
                        leftPoint++;
                    }
                }
            }
        }

        if (n > 2) {
            for (int i = start; i < nums.length; i++) {
                int first = nums[i];
                List<List<Integer>> lists = nSums(nums, n - 1, i + 1, target - nums[i]);
                if (CollectionUtils.isNotEmpty(lists)) {
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
        NSum nSum = new NSum();
        int[] nums = {5, 3, 1, 6};
        int target = 9;
        int[] ints = nSum.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println("-------------------");
        nums = new int[]{9, 8, 8, 8, 0};
        target = 16;
        List<List<Integer>> pairs = nSum.twoSums(nums, target);
        System.out.println(JSON.toJSONString(pairs));
        System.out.println("-------------------");
        nums = new int[]{1, 2, 3, 4, 4, -1, -1, 0};
        target = 3;
        List<List<Integer>> threeSums = nSum.threeSums(nums, target);
        System.out.println(JSON.toJSONString(threeSums));
        System.out.println("-------------------");
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> nSums = nSum.nSums(nums, 3, 0, 0);
        System.out.println(JSON.toJSONString(nSums));
    }

}
