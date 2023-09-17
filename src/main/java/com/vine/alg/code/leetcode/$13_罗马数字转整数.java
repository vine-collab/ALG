package com.vine.alg.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2023-09-16 3:09 PM
 */

public class $13_罗马数字转整数 {


    /**
     * https://leetcode.cn/problems/roman-to-integer/description/
     */
    public static void main(String[] args) {
        $13_罗马数字转整数 z = new $13_罗马数字转整数();
        int iii = z.romanToInt("MCMXCIV");
        System.out.println(iii);
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int res = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (i <= s.length() - 2) {
                char d = s.charAt(i + 1);
                if (c == 'I') {
                    if (d == 'V') {
                        res += 4;
                        i += 2;
                        continue;
                    }

                    if (d == 'X') {
                        res += 9;
                        i += 2;
                        continue;
                    }
                } else if (c == 'X') {
                    if (d == 'L') {
                        res += 40;
                        i += 2;
                        continue;
                    }
                    if (d == 'C') {
                        res += 90;
                        i += 2;
                        continue;
                    }

                } else if (c == 'C') {
                    if (d == 'D') {
                        res += 400;
                        i += 2;
                        continue;
                    }

                    if (d == 'M') {
                        res += 900;
                        i += 2;
                        continue;
                    }

                }
            }
            res += map.get(c);
            i++;

        }
        return res;

    }

}
