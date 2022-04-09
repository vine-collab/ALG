package com.vine.alg.BFS算法套路框架;

import com.google.common.collect.Sets;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

/**
 * @author 阿季
 * @date 2022-04-08 9:17 AM
 */

public class 开密码锁最少次数 {

    public static void main(String[] args) {
        开密码锁最少次数 k = new 开密码锁最少次数();
        int i = k.openLock(new String[]{"1008", "1000"}, "0009");
        System.out.println(i);
    }

    int openLock(String[] deadends, String target) {

        Queue<String> queue = new ArrayDeque<>();
        Set<String> dead = Sets.newHashSet(deadends);
        Set<String> visited = Sets.newHashSet();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }


                for (int j = 0; j < cur.length(); j++) {
                    String plus = plus(cur, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                }
                for (int j = 0; j < cur.length(); j++) {
                    String minus = minus(cur, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }

            }
            step++;
        }
        return -1;
    }


    String plus(String s, int pos) {
        char[] chars = s.toCharArray();
        if (chars[pos] == '9') {
            chars[pos] = '0';
        } else {
            chars[pos] += 1;
        }


        return new String(chars);
    }

    String minus(String s, int pos) {
        char[] chars = s.toCharArray();
        if (chars[pos] == '0') {
            chars[pos] = '9';
        } else {
            chars[pos] -= 1;
        }


        return new String(chars);
    }

}
