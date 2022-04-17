package com.vine.alg.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-04-17 4:07 PM
 */

public class 戳气球 {
    public static void main(String[] args) {
        try {
            戳气球 b = new 戳气球();
            int i = b.maxBalloon(new int[]{3, 1, 5, 8});
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int res = Integer.MIN_VALUE;


    int maxBalloon(int[] nums) {
        // 给nums，首尾插1
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        arr.add(0, 1);
        arr.add(arr.size(), 1);
        backtrack(arr, 0);
        return res;
    }

    /*
        回溯解法，穷举所有结果
     */
    void backtrack(List<Integer> nums, int score) {
        // 气球全部戳完了,nums为空的时候
        if (nums.size() == 2) {
            res = Integer.max(res, score);
            return;
        }

        for (int i = 1; i < nums.size() - 1; i++) {
            int point = 0;
//            if (i == 0 && nums.size() != 1) {
//                point = nums.get(i) * nums.get(i + 1);
//            } else if (i == nums.size() - 1 && nums.size() != 1) {
//                point = nums.get(i) * nums.get(i - 1);
//            } else if (nums.size() >= 3) {
//                point = nums.get(i) * nums.get(i + 1) * nums.get(i - 1);
//            }

            point = nums.get(i) * nums.get(i + 1) * nums.get(i - 1);
            // 删除第i个元素
            List<Integer> temp = new ArrayList<>(nums);
            Integer remove = temp.remove(i);
            backtrack(temp, score + point);
            temp.add(i, remove);
        }


    }


}



















