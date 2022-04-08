package com.vine.alg.BFS算法套路框架;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.vine.alg.基本数据结构构造.TreeNode;

import javax.swing.text.html.HTML;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author 阿季
 * @date 2022-04-07 9:50 PM
 */

public class 二叉树的最小高度 {

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-4);
        TreeNode node6 = new TreeNode(-5);
        TreeNode node7 = new TreeNode(5);
        rootNode.leftChild = node1;
        rootNode.rightChild = node2;

//        node1.rightChild = node3;
        node2.leftChild = node4;

        node3.leftChild = node5;
//        node4.rightChild = node6;

//        node6.leftChild = node7;


        System.out.println(JSON.toJSONString(rootNode, SerializerFeature.DisableCircularReferenceDetect));

        二叉树的最小高度 e = new 二叉树的最小高度();
        int depth = e.binaryTreeMinDepth(rootNode);
        System.out.println(depth);


    }

    /**
     * 分析：起点：根节点，终点（叶子节点）：条件(左子树和右子树都不存在)，node.left == null && node.right == null
     */
    int binaryTreeMinDepth(TreeNode tree) {
        if(tree == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        // 根节点默认高度1
        int high = 1;

        while (queue.size() != 0) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                if (cur.leftChild == null && cur.rightChild == null) {
                    return high;
                }

                if (cur.leftChild != null) {
                    queue.add(cur.leftChild);
                }

                if (cur.rightChild != null) {
                    queue.add(cur.rightChild);
                }
            }
            high++;
        }

        return high;
    }


}



























