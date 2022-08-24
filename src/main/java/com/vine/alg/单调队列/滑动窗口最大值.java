package com.vine.alg.单调队列;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-10 8:27 PM
 */

public class 滑动窗口最大值 {


    public static void main(String[] args) {
        滑动窗口最大值 h = new 滑动窗口最大值();
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints1 = h.maxSlidingWindow(ints, 3);
        System.out.println(JSON.toJSONString(ints1));


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }

        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }


}































































