package com.vine.alg.leetcode.leetcode;

/**
 * @author 阿季
 * @date 2022-05-01 4:50 PM
 */

public class $7_整数反转 {

    /*
    7. 整数反转
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

    假设环境不允许存储 64 位整数（有符号或无符号）。


    示例 1：

    输入：x = 123
    输出：321
    示例 2：

    输入：x = -123
    输出：-321
    示例 3：

    输入：x = 120
    输出：21
    示例 4：

    输入：x = 0
    输出：0
     */

    public static void main(String[] args) {
        $7_整数反转 z = new $7_整数反转();
        int reverse = z.reverse(1534236469);
        System.out.println(reverse);
    }

    public int reverse(int x) {

        long result = 0;
        int scale = 10;
        while (x != 0) {
            int i = x % scale;
            if (i != 0) {
                result = result + i;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    return 0;
                }
            }
            x = x / scale;
            if(x != 0) {
                result *= scale;
            }
        }
        return (int) result;
    }

}
