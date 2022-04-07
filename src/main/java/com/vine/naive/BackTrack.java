package com.vine.naive;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯
 *
 * @author 阿季
 * @date 2021-04-22 10:57
 */

public class BackTrack {

    private static List<List<Integer>> result = Lists.newLinkedList();

    public void backTrack(Integer[] nums,  List<Integer> track) {

        if(nums.length == track.size()) {
            result.add(Lists.newLinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
        Integer[] nums = {1,2,3};
        backTrack.backTrack(nums, new LinkedList<>());
        System.out.println(result);
    }


}
