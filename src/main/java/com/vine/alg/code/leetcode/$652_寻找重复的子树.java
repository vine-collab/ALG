package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-07-13 8:31 PM
 */

public class $652_寻找重复的子树 {

    /**
     * https://leetcode.cn/problems/find-duplicate-subtrees/
     */
    public static void main(String[] args) {
        $652_寻找重复的子树 x = new $652_寻找重复的子树();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;

    }

    Map<String, Integer> map = new HashMap<>();

    List<TreeNode> res = new ArrayList<>();

    String traverse(TreeNode root) {
        if (root == null) {
            return "x";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String path = left + "-" + right + "-" + root.val;
        if (map.getOrDefault(path, 0) == 1) {
            res.add(root);
        }
        map.put(path, map.getOrDefault(path, 0) + 1);

        return path;
    }

}
