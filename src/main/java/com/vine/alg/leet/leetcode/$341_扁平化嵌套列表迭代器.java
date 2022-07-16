package com.vine.alg.leet.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-07-16 4:19 PM
 */

public class $341_扁平化嵌套列表迭代器 {


    public static void main(String[] args) {
        $341_扁平化嵌套列表迭代器 p = new $341_扁平化嵌套列表迭代器();
    }


    public class NestedIterator implements Iterator<Integer> {

        private Iterator<Integer> it;


        public NestedIterator(List<NestedInteger> nestedList) {
            // 存放将nestedList打平的结果
            List<Integer> res = new LinkedList<>();
            for (NestedInteger node : nestedList) {
                this.traverse(node, res);
            }
            this.it = res.iterator();

        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        // 多叉树的遍历，将叶子节点加入result列表
        void traverse(NestedInteger root, List<Integer> res) {
            if (root.isInteger()) {
                // 到达叶子节点
                res.add(root.getInteger());
                return;
            }
            // 遍历子树
            for (NestedInteger child : root.getList()) {
                this.traverse(child, res);
            }

        }

    }


}


class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    // 如果其中存的是一个整数，则返回 true，否则返回 false
    public boolean isInteger() {
        return val != null;
    }

    // 如果其中存的是一个整数，则返回这个整数，否则返回 null
    public Integer getInteger() {
        return this.val;
    }

    // 如果其中存的是一个列表，则返回这个列表，否则返回 null
    public List<NestedInteger> getList() {
        return this.list;
    }


    public class NestedIterator implements Iterator<Integer> {


        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {

            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            // 循环拆分列表元素，直到列表第一个元素是整数
            while (!list.isEmpty() && !list.get(0).isInteger()) {
                // 第一个元素是列表，继续拆
                List<NestedInteger> first = list.remove(0).getList();
                // 将第一个列表打平并按顺序添加到开头, 倒序遍历，头插法
                for (int i = first.size() - 1; i >= 0; i--) {
                    list.addFirst(first.get(i));
                }
            }
            return !list.isEmpty();

        }
    }
}






























