package com.jlp.alg.bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {


    public List<TreeNode> generateTrees(int n) {


        return null;
    }

    public static void main(String[] args) {
        System.out.println(numOfWays(1, 3));
    }



    public static List<TreeNode> numOfWays(int start, int end) {
        //k位0，则没有可能性
        if (start > end) {
            List<TreeNode> ways = new ArrayList<>();
            ways.add(null);
            return ways;
        }
        List<TreeNode> newList = new ArrayList<>();
        int step = start;
        while (step <= end) {
            List<TreeNode> wayLeft = numOfWays(start, step-1);
            List<TreeNode> wayRight = numOfWays(step + 1, end);
            for (int i = 0; i < wayLeft.size(); i++) {
                for (int j = 0; j < wayRight.size(); j++) {
                    TreeNode root = new TreeNode(step);
                    if (null != wayLeft.get(i) || null != wayRight.get(i)) {
                        root.left = wayLeft.get(i);
                        root.right = wayRight.get(j);
                    }
                    newList.add(root);
                }
            }
            step++;
        }
        return newList;
    }
}
