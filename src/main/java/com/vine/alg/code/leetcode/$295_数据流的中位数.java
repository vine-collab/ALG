package com.vine.alg.code.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-07-19 9:05 PM
 */

public class $295_数据流的中位数 {


    /**
     * https://leetcode.cn/problems/find-median-from-data-stream/
     */
    public static void main(String[] args) {
        $295_数据流的中位数 z = new $295_数据流的中位数();
    }

    Queue<Integer> small;

    Queue<Integer> large;

    public $295_数据流的中位数() {
        large = new PriorityQueue<Integer>();
        small = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (small.size() > large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 两个数据不一样多的时候，多的就是中位数
        if (small.size() > large.size()) {
            return small.peek();
        }
        if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;
    }


}































































