package com.vine.alg.code.topcode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.*;

/**
 * @author 阿季
 * @date 2023-08-27 12:06
 */

public class $752_打开转盘锁 {

    public static void main(String[] args) {
        $752_打开转盘锁 z = new $752_打开转盘锁();
    }


    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if(dead.contains(cur)) {
                    continue;
                }

                if (cur.equals(target)) {
                    return count;
                }

                for (int j = 0; j < cur.length(); j++) {
                    String plus = plus(cur, i);
                    if (visited.add(plus)) {
                        queue.offer(plus);
                    }
                    String down = down(cur, i);
                    if(visited.add(down)) {
                        queue.offer(down);
                    }
                }


            }
            count++;
        }

        return -1;

    }


    String plus(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9')
            ch[i] = '0';
        else
            ch[i] += 1;
        return new String(ch);
    }

    String down(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0')
            ch[i] = '9';
        else
            ch[i] -= 1;
        return new String(ch);
    }


}































































