package com.jlp.alg.bfsdfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 一颗二叉树
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;

    private int level;
    private int val;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inv(root, list);
        return list;
    }

    public void inv(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inv(root.left, res);
        res.add(root.val);
        inv(root.right, res);
    }


    /**
     * 栈
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            //如果有左节点，当前节点入栈，指针指向左子节点
            if (null != head.left) {
                stack.push(head);
                //左子节点已遍历，不再关注
                head = head.left;
            } else {
                //没有左子节点，当前值入库，指向右子节点
                list.add(head.val);
                head = head.right;
                //也没有右子节点，从栈中获取
                if (head == null && !stack.isEmpty()) {
                    head = stack.pop();
                    head.left = null;
                }
            }
        }
        return list;
    }



}
