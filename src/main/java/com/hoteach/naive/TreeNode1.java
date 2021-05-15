package com.hoteach.naive;

import java.util.Objects;

public class TreeNode1 {
    private int val;
    private TreeNode1 left;
    private TreeNode1 right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode1 getLeft() {
        return left;
    }

    public void setLeft(TreeNode1 left) {
        this.left = left;
    }

    public TreeNode1 getRight() {
        return right;
    }

    public void setRight(TreeNode1 right) {
        this.right = right;
    }

    TreeNode1(int val) {
        this.val = val;
    }


}

class Solution {
    public TreeNode1 insertIntoBST(TreeNode1 root, int val) {
        if(Objects.isNull(root)) {
            return new TreeNode1(val);
        }
        if(val > root.getVal()) {
            root.setRight(insertIntoBST(root.getRight(), val));
        }

        if(val < root.getVal()) {
            root.setLeft(insertIntoBST(root.getLeft(), val));
        }
        return root;
    }
}