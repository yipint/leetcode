package com.example.demotest.leetcode.editor.cn;

import java.util.List;

/**
 * @author tianyipin
 * @desc
 * @since 2023/4/20
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
