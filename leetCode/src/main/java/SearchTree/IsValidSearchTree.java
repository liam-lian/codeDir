package main.java.SearchTree;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */


import main.java._entity.TreeNode;

public class IsValidSearchTree {

    private int before=Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isValidBST(root.left) && compare(root.val) && isValidBST(root.right);
    }

    private boolean compare(int val){
        if(val<before) return false;
        before=val;
        return true;
    }
}
