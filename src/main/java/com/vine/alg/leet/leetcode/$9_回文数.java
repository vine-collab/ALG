package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-05-02 5:58 PM
 */

public class $9_回文数 {

    public static void main(String[] args) {
        $9_回文数 h = new $9_回文数();
        boolean palindrome = h.isPalindrome(00);
        System.out.println(palindrome);

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;



    }
}
