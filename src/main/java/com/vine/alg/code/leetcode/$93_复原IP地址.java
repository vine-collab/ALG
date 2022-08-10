package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-09 8:39 PM
 */

public class $93_复原IP地址 {


    /**
     * https://leetcode.cn/problems/restore-ip-addresses/
     */
    public static void main(String[] args) {
        $93_复原IP地址 f = new $93_复原IP地址();
        List<String> strings = f.restoreIpAddresses("0000");
        System.out.println(JSON.toJSONString(strings));
    }


    /**
     * 递归函数  表示我们正在从 s(index) 的位置开始，搜索 IP 地址中的第 part 段，其中 part∈{0,1,2,3}。
     * 在搜索的过程中，如果我们已经得到了全部的 44 段 IP 地址（即 part=4）
     */
    public List<String> restoreIpAddresses(String s) {
        this.dfs(s, 0, 0);
        return res;

    }

    int[] segments = new int[4];

    List<String> res = new ArrayList<>();

    // part 表示生成ip地址的短, index 表示当前回溯到s的位置
    void dfs(String s, int part, int index) {
        if (part == 4) { // 已经切了四段
            if (index == s.length()) { // 回溯到字符串的末尾
                // 添加结果集
                addRes();
            }
            return;
        }
        // 到了结尾
        if (index == s.length()) {
            return;
        }
        // 遇到0 只能是0段
        if (s.charAt(index) == '0') {
            segments[part] = 0;
            this.dfs(s, part + 1, index + 1);
        }
        int segment = 0;
        for (int i = index; i < s.length(); i++) {
            segment = segment * 10 + (s.charAt(i) - '0');
            if (segment > 255 || segment == 0) { // 如果大于 255 或者 是多个0的情况，停止回溯
                break;
            }
            segments[part] = segment;
            this.dfs(s, part + 1, i + 1);
        }
    }


    void addRes() {
        StringBuffer ipAddr = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            ipAddr.append(segments[i]);
            if (i != 4 - 1) {
                ipAddr.append('.');
            }
        }
        res.add(ipAddr.toString());
    }


}































































