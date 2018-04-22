package SearchTree;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.TreeNode;

import java.util.ArrayDeque;

public class BSTIterator {

    ArrayDeque<TreeNode> stack=new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        while (root!=null){
            stack.offerLast(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode node=stack.pollLast();
        if(node.right!=null){
            TreeNode t=node.right;
            while (t!=null){
                stack.offerLast(t);
                t=t.left;
            }
        }
        return node.val;
    }

}
