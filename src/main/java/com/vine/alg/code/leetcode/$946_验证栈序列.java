package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2023-10-12 9:15 PM
 */

public class $946_验证栈序列 {


    public static void main(String[] args) {
        $946_验证栈序列 z = new $946_验证栈序列();
        boolean b = z.validateStackSequences(Utils.splitToIntArr1("1,2,3,4,5"), Utils.splitToIntArr1("4,5,3,2,1"));
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++) {
            stk.push(pushed[i]);
            while(!stk.isEmpty() && stk.peek() == popped[j]) {
                stk.pop();
                j++;
            }

        }

        return stk.isEmpty();



    }

}
