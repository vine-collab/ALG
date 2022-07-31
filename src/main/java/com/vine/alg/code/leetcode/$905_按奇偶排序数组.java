package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-04-28 9:29 PM
 */

public class $905_按奇偶排序数组 {


    /*
    905. 按奇偶排序数组
    给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。

    返回满足此条件的 任一数组 作为答案。

    示例 1：

    输入：nums = [3,1,2,4]
    输出：[2,4,3,1]
    解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
    示例 2：

    输入：nums = [0]
    输出：[0]

     */

    public static void main(String[] args) {
        $905_按奇偶排序数组 a = new $905_按奇偶排序数组();
        int[] ints = a.sortArrayByParity(new int[]{3,1,2,4});
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int l = nums[left];
            int r = nums[right];
            if(l % 2 == 0){
                left++;
            } else
            if(r % 2 != 0){
                right--;
            } else {
                nums[left] = nums[right];
                nums[right] = l;
                left++;
                right--;
            }

        }
        return nums;
    }


}















