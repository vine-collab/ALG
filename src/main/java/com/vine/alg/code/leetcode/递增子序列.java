package com.vine.alg.code.leetcode;

import java.util.*;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 提示：
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是[-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 阿季
 * @date 2021-05-20 11:27
 */

public class 递增子序列 {


    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        backTrack(nums, new LinkedList<>(), 0, result);

        return new ArrayList<>(result);
    }

    private static List<List<Integer>> result = new ArrayList<>();

    public void backTrack(int[] nums, LinkedList<Integer> track, int start, Set<List<Integer>> result) {

        if (track.size() >= 2) {
            result.add(new ArrayList<>(track));
        }

        for (int i = start; i < nums.length; i++) {
            if (!track.isEmpty() && track.getLast() > nums[i]) {
                continue;
            }
            track.addLast(nums[i]);
            backTrack(nums, track, i + 1, result);
            track.removeLast();
        }
    }


    private void backtracking(int[] nums, List<Integer> path, int start, List<List<Integer>> result) {
        // 对于当前的路径，根据题目要求，递增子序列的长度至少是 2，
        // 因此，当前路径的长度大于等于 2 的时候，我就开始收集结果
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 在 path 中含有元素的情况下，
            // 如果当前遍历到的 nums[i] 比 path 中最后添加的那个元素要小的话，
            // 那么就构不成递增序列，此时直接 continue。
            // 同时，如果 set 已经存在了当前 nums[i] 的话，
            // 那么我们也是不考虑的
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)
                    || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            // 这里需要注意的是：
            // 应该是 i + 1，而不是 start + 1
            backtracking(nums, path, i + 1, result);
            // 回溯操作
            path.remove(path.size() - 1);
        }

    }


    public static void main(String[] args) {
        递增子序列 c = new 递增子序列();
        int[] nums = {4, 6, 7, 7};
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        long start = System.currentTimeMillis();
        List<List<Integer>> subsequences = c.findSubsequences(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


}














