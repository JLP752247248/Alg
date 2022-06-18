package com.jlp.alg.bfsdfs;


import java.util.ArrayList;
import java.util.List;

/**
 * 一颗二叉树
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

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
    public List<Integer> midorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inv(root, list);
        return list;
    }

    public void inv(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return;
        }
        boolean notLeaf = root.left !=null || root.right != null;
        res.add(root.val);
        if(notLeaf){
            inv(root.left, res);
        }
        if(notLeaf){
            inv(root.right, res);
        }

    }

    @Override
    public String toString() {
        return midorderTraversal(this).toString();
    }
}
