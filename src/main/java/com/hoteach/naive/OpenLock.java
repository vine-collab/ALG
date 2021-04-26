package com.hoteach.naive;

import java.util.*;

/**
 * 开锁
 *
 * @author 阿季
 * @date 2021-04-26 17:41
 */

public class OpenLock {


    public int open(String start, String target, Set<String> dead) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(dead);
        q.offer(start);
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String poll = q.poll();
                if (Objects.equals(poll, target)) {
                    return step;
                }
                int length = start.length();
                for (int j = 0; j < length; j++) {
                    String plus = plus(poll, j);
                    if (visited.add(plus)) {
                        q.offer(plus);
                    }
                    String subtract = subtract(poll, j);
                    if (visited.add(subtract)) {
                        q.offer(subtract);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public String plus(String param, int j) {
        char[] chars = param.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }


    public String subtract(String param, int j) {
        char[] chars = param.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        int open = openLock.open("0000", "0010", new HashSet<>());
        System.out.println(open);
    }


}
