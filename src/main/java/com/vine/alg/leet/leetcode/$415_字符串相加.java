package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-07-30 4:32 PM
 */

public class $415_字符串相加 {

    /**
     * https://leetcode.cn/problems/add-strings/
     * <p>
     * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
     * <p>
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * 示例 2：
     * <p>
     * 输入：num1 = "456", num2 = "77"
     * 输出："533"
     * 示例 3：
     * <p>
     * 输入：num1 = "0", num2 = "0"
     * 输出："0"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        $415_字符串相加 z = new $415_字符串相加();
        String s = z.addStrings1("6", "501");
        System.out.println(s);
    }


    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int temp = 0;
        while (l1 != -1 && l2 != -1) {
            int sum = Character.getNumericValue(num1.charAt(l1)) + Character.getNumericValue(num2.charAt(l2)) + temp;
            int i = sum % 10;
            temp = sum / 10;
            res.append(i);
            l1--;
            l2--;
        }
        if (l1 != -1) {
            while (l1 != -1) {
                int sum = Character.getNumericValue(num1.charAt(l1)) + temp;
                int i = sum % 10;
                temp = sum / 10;
                res.append(i);
                l1--;
            }
        } else {
            while (l2 != -1) {
                int sum = Character.getNumericValue(num2.charAt(l2)) + temp;
                int i = sum % 10;
                temp = sum / 10;
                res.append(i);
                l2--;
            }
        }
        if (temp != 0) {
            res.append(temp);
        }

        return res.reverse().toString();
    }


    public String addStrings1(String num1, String num2) {

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int remainder = 0;

        while (l1 >= 0 || l2 >= 0 || remainder != 0) {
            int x = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int y = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = x + y + remainder;
            res.append(sum % 10);
            remainder = sum / 10;
            l1--;
            l2--;
        }

        return res.reverse().toString();

    }


}































































