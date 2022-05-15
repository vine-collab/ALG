package com.vine.alg.leetcode.leetcode;

/**
 * @author 阿季
 * @date 2022-05-04 5:48 PM
 */

public class $33_搜索旋转排序数组 {


    /*
    33. 搜索旋转排序数组
    整数数组 nums 按升序排列，数组中的值 互不相同 。

    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
    使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

    示例 1：

    输入：nums = [4,5,6,7,0,1,2], target = 0
    输出：4

    示例 2：
    输入：nums = [4,5,6,7,0,1,2], target = 3
    输出：-1

    示例 3：
    输入：nums = [1], target = 0
    输出：-1
     */


    public static void main(String[] args) {
        $33_搜索旋转排序数组 s = new $33_搜索旋转排序数组();
        int[] ints = {5, 3, 1};
        int search = s.search(ints, 5, 0, ints.length - 1);
        System.out.println(search);
        Integer integer = 100;
        Integer integer2 = 100;
        System.out.println(integer == integer2);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = nums[middle];
            if (m == target) {
                return middle;
            }
            // 左侧是有序的
            if (nums[0] <= nums[middle]) {
                if (nums[0] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // 右侧是有序数组
            else {
                if (nums[middle] < target && target <= nums[nums.length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

        }
        return -1;

    }


    public int search(int[] nums, int target, int start, int end) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (start == end) {
            return nums[start] == target ? start : -1;
        }


        int left = start, right = end;

        int middle = left + (right - left) / 2;
        int num = nums[middle];
        if (num == target) {
            return middle;
        }

        if (nums[start] <= target && target < num) {
            return search(nums, target, start, middle - 1);
        } else {
            return search(nums, target, middle + 1, end);
        }


    }


}

















