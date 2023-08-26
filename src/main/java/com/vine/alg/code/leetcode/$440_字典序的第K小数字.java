package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2023-08-20 17:08
 */

public class $440_字典序的第K小数字 {

    public static void main(String[] args) {
        $440_字典序的第K小数字 z = new $440_字典序的第K小数字();
        int kthNumber = z.findKthNumber(13, 2);
        System.out.println(kthNumber);

    }

    /**
     * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 13, k = 2
     * 输出: 10
     * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
     * 示例 2:
     * <p>
     * 输入: n = 1, k = 1
     * 输出: 1
     * https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/
     */


    public int findKthNumber(int n, int k) {
        int p = 1; //作为一个指针，指向当前所在位置，当p==k时，也就是到了排位第k的数
        int prefix = 1; //当前前缀
        while(p < k) {
            long count = getCount(n, prefix); //获得当前前缀下所有子节点的总数
            if(p + count > k) { //第k个数在当前前缀下
                prefix *= 10;
                p++; //把指针指向了第一个子节点的位置，比如11乘10后变成110，指针从11指向了110
            } else { //第k个数不在当前前缀下
                prefix++;
                p += count; //注意这里的操作，把指针指向了下一前缀的起点
            }
        }
        return prefix;
    }


    long getCount(int n, int prefix) {
        long count = 0; // 当前前缀下面节点总数
        long cur = prefix; // 当前前缀
        long next = prefix + 1; // 下一个前缀
        while(cur <= n) { // 总数不能超过n
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count; // 返回当前前缀下面节点的总和
    }

    int findK(int n, int k) {
        int p = 1; // 当前节点指针
        int prefix = 1; // 当前前缀
        while(p < k) {
            // 获取当前前缀下的左右节点个数
            long cnt = getCnt(n, prefix);
            if(p + cnt > k) { // 第k个大数在当前前缀下
                prefix *= 10; //子节点第一个节点
                p++; // 指针指向第一个子节点
            } else {
                prefix++; // 下一个前缀
                p += cnt; //注意这里的操作，把指针指向了下一前缀的起点
            }
        }
        return prefix;
    }

    long getCnt(int n, int prefix) {
        long cnt = 0;
        long cur = prefix;
        long next = prefix + 1;

        while(cur <= n) {
            cnt += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return cnt;
    }


}































































