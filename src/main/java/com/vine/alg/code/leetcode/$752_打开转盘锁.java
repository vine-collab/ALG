package com.vine.alg.code.leetcode;

import java.util.*;

/**
 * @author 阿季
 * @date 2023-04-24 10:26 PM
 */

public class $752_打开转盘锁 {


    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * <p>
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * <p>
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * <p>
     * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
     * <p>
     * 示例 1:
     * <p>
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     * 示例 2:
     * <p>
     * 输入: deadends = ["8888"], target = "0009"
     * 输出：1
     * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
     * 示例 3:
     * <p>
     * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
     * 输出：-1
     * 解释：无法旋转到目标数字且不被锁定。
     * <p>
     * 链接：https://leetcode.cn/problems/open-the-lock
     */
    public static void main(String[] args) {
        $752_打开转盘锁 z = new $752_打开转盘锁();
        String[] strings = {"0201", "0101", "0102", "1212", "2002"};
        int i = z.openLock(strings, "0202");
        System.out.println(i);

    }

    public int openLock(String[] deadends, String target) {

        int count = 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int m = 0; m < size; m++) {
                String cur = q.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (Objects.equals(cur, target)) {
                    return count;
                }

                for (int i = 0; i < cur.length(); i++) {
                    String up = up(cur, i);
                    if (visited.add(up)) {
                        q.offer(up);
                    }
                    String down = down(cur, i);
                    if (visited.add(down)) {
                        q.offer(down);
                    }
                }
            }
            count++;
        }
        return -1;

    }

    String up(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }


    String down(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }


}































































