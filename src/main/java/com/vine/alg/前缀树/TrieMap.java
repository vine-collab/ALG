package com.vine.alg.前缀树;

import java.util.LinkedList;
import java.util.List;

public class TrieMap<V> {


    // ASCII 码个数
    private static final int R = 256;
    // 当前存在 Map 中的键值对个数
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    // Trie 树的根节点
    private TrieNode<V> root = null;

    /* 其他 API 的实现... */

    public int size() {
        return size;
    }


    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        if (key == null) {
            return null;
        }
        TrieNode<V> p = node;
        // 从节点 node 开始搜索 key
        for (int i = 0; i < key.length(); i++) {
            if (p == null) {
                // 无法向下搜索
                return null;
            }
            // 向下搜索
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    // 搜索 key 对应的值，不存在则返回 null
    public V get(String key) {
        // 从 root 开始搜索 key
        TrieNode<V> x = this.getNode(root, key);
        if (x == null || x.val == null) {
            // x 为空或 x 的 val 字段为空都说明 key 没有对应的值
            return null;
        }
        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    // 这里需要注意，就算getNode(key)的返回值x非空，也只能说字符串key是一个「前缀」；除非x.val同时非空，才能判断键key存在。
    public boolean containsKey(String key) {
        return this.get(key) != null;
    }


    // 在所有键中寻找 query 的最短前缀
    public String shortestPrefixOf(String query) {

        TrieNode<V> p = root;
        // 从root节点开始搜索
        for (int i = 0; i < query.length(); i++) {
            // 无法继续向下搜索
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                return query.substring(0, i);// 找到一个键是前缀
            }
            // 继续搜索
            char c = query.charAt(i);
            p = p.children[c];
        }

        if (p != null && p.val != null) {
            //  query本身也是一个键
            return query;
        }
        return "";
    }

    // 在所有键中寻找 query 的最长前缀
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        int maxLength = 0;

        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                break;
            }

            if (p.val != null) {
                maxLength = i;
            }
            char c = query.charAt(i);
            p = p.children[c];
        }

        if (p != null && p.val != null) {
            return query;
        }

        return query.substring(0, maxLength);

    }

    // 搜索前缀为 prefix 的所有键
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new LinkedList<>();
        TrieNode<V> node = this.getNode(root, prefix);
        if (node == null) {
            return res;
        }
        this.traverse(node, new StringBuilder(prefix), res);

        return res;
    }


    // 遍历以 node 节点为根的 Trie 树，找到所有键
    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) {
            // 到达叶节点
            return;
        }

        if (node.val != null) {
            res.add(path.toString());
        }

        for (char i = 0; i < R; i++) {
            path.append(i);

            this.traverse(node.children[i], path, res);

            path.deleteCharAt(path.length() - 1);
        }
    }


    // 通配符 . 匹配任意字符
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }


    // 遍历函数，尝试在「以 node 为根的 Trie 树中」匹配 pattern[i..]
    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node == null) {
            return;
        }

        if (i == pattern.length()) {
            // 找到一个匹配的key
            if (node.val != null) {
                res.add(path.toString());
            }
            return;
        }

        char c = pattern.charAt(i);
        if (c == '.') {
            // pattern[i] 是通配符
            for (char j = 0; j < R; j++) {
                path.append(j);

                this.traverse(node.children[j], path, res);

                path.deleteCharAt(path.length() - 1);
            }
        } else {
            // 不是通配符
            path.append(c);
            this.traverse(node.children[c], path, pattern, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }

    }


    // 判断是和否存在前缀为 prefix 的键
    public boolean hasKeyWithPattern(String pattern) {
        // 从 root 节点开始匹配 pattern[0..]
        return hasKeyWithPattern(root, pattern, 0);
    }

    // 函数定义：从 node 节点开始匹配 pattern[i..]，返回是否成功匹配
    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        // 匹配失败
        if (node == null) {
            return false;
        }
        if (i == pattern.length()) {
            // 模式串走到头了，看看匹配到的是否是一个键
            return node.val != null;
        }

        char c = pattern.charAt(i);
        if (c != '.') {
            // 从 node.children[c] 节点开始匹配 pattern[i+1..]
            return this.hasKeyWithPattern(node.children[c], pattern, i + 1);
        }
        // 遇到通配符
        for (int j = 0; j < R; j++) {
            // pattern[i] 可以变化成任意字符，尝试所有可能，只要遇到一个匹配成功就返回
            if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                return true;
            }
        }
        // 都没有匹配
        return false;
    }

    // 在 map 中添加或修改键值对
    public void put(String key, V val) {
        if (!this.containsKey(key)) {
            // 新增键值对
            size++;
        }
        // 需要一个额外的辅助函数，并接收其返回值
        root = this.put(root, key, val, 0);
    }


    // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieNode<>();
        }

        if (i == key.length()) {
            node.val = val;
            return node;
        }

        char c = key.charAt(i);
        node.children[c] = this.put(node.children[c], key, val, i + 1);
        return node;
    }

    // 在 Map 中删除 key
    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        // 递归修改数据结构要接收函数的返回值
        root = this.remove(root, key, 0);
        size--;
    }

    // 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if(node == null) {
            return null;
        }
        // 找到了 key 对应的 TrieNode，删除 val
        if(i == key.length()) {
            node.val = null;
        } else {
            char c = key.charAt(i);
            // 递归去子树进行删除
            node.children[c]= this.remove(node.children[c], key, i + 1);
        }


        // 后序位置，递归路径上的节点可能需要被清理
        if (node.val != null) {
            // 如果该 TireNode 存储着 val，不需要被清理
            return node;
        }
        // 检查该 TrieNode 是否还有后缀
        for (int c = 0; c < R; c++) {
            if (node.children[c] != null) {
                // 只要存在一个子节点（后缀树枝），就不需要被清理
                return node;
            }
        }
        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }
}






















