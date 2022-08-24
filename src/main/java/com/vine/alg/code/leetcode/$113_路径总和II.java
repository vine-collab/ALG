package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-13 5:39 PM
 */

public class $113_路径总和II {


    public static void main(String[] args) {
        $113_路径总和II z = new $113_路径总和II();
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);


        List<List<Integer>> lists = z.pathSum(r, 3);
        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, new LinkedList<>(), targetSum);

        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    void traverse(TreeNode root, LinkedList<Integer> cur, int targetSum) {

        if (root == null) {
            return;
        }

        int remain = targetSum - root.val;

        if (root.left == null && root.right == null) {
            if(remain == 0) {
                cur.addLast(root.val);
                res.add(new ArrayList(cur));
                cur.removeLast();
            }
            return;
        }


        cur.addLast(root.val);
        traverse(root.left, cur, remain);
        cur.removeLast();


        cur.addLast(root.val);
        traverse(root.right, cur, remain);
        cur.removeLast();
    }

}


































































