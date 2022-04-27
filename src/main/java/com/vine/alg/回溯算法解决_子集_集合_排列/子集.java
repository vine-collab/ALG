package com.vine.alg.回溯算法解决_子集_集合_排列;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author 阿季
 * @date 2022-04-27 8:34 PM
 */

public class 子集 {

    /*
        78. 子集
        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

        示例 1：

        输入：nums = [1,2,3]
        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        示例 2：

        输入：nums = [0]
        输出：[[],[0]]
     */

    public static void main(String[] args) {
        子集 z = new 子集();
        List<List<Integer>> subsets = z.subsets2(new int[]{1, 2, 3});
        System.out.println(JSON.toJSONString(subsets, SerializerFeature.DisableCircularReferenceDetect));
    }

    List<List<Integer>> res = new ArrayList<>();


    /*
        选择
     */
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new LinkedList<>(), 0);
        res.add(new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> cur, int pos) {
        // 结果中没有当前子集时
        if (!contains(cur)) {
            List<Integer> sub = new ArrayList<>(cur);
            res.add(sub);
        }

        for (int i = pos; i < nums.length; i++) {
            int num = nums[i];
            if (cur.contains(num)) {
                continue;
            }
            cur.add(num);
            backtrack(nums, cur, i + 1);
            cur.removeLast();
        }
    }


    boolean contains(List<Integer> cur) {
        if (res.size() == 0 && cur.size() == 0) {
            return true;
        }
        for (List<Integer> r : res) {
            if (cur.size() != r.size()) {
                continue;
            }
            return cur.containsAll(r);
        }
        return false;
    }


    public List<List<Integer>> subsets2(int[] nums) {
        if (nums.length == 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            List<List<Integer>> r = new ArrayList<>();
            r.add(integers);
            return r;
        }

        int[] ints = Arrays.copyOf(nums, nums.length - 1);
        List<List<Integer>> res = subsets2(ints);


        List<List<Integer>> resCopy = new ArrayList<>();


        for (List<Integer> subset : res) {
            resCopy.add(new ArrayList<>(subset));
            if (!subset.contains(nums[nums.length - 1]))
                subset.add(nums[nums.length - 1]);
        }
        res.addAll(resCopy);

        return res;
    }


}













