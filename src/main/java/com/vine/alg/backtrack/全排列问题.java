package com.vine.alg.backtrack;

import com.alibaba.fastjson.JSON;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-04-05 8:34 PM
 */
@Getter
public class 全排列问题 {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        全排列问题 c = new 全排列问题();
        c.traverse(list, new LinkedList<>());
        System.out.println(JSON.toJSONString(c.result));

    }


    void traverse(List<Integer> list, LinkedList<Integer> track) {
        if (track.size() == list.size()) {
            result.add(new LinkedList<>(track));
            return;
        }


        for (int i = 0; i < list.size(); i++) {
            if (track.contains(list.get(i))) {
                continue;
            }
            track.add(list.get(i));
            traverse(list, track);
            track.removeLast();

        }
    }


}

