package SearchTree;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.TreeNode;

public class DeleteNode {



    private TreeNode findMin(TreeNode deleteNode){

        if(deleteNode.left==null) return deleteNode.right;
        if(deleteNode.right==null) return deleteNode.left;

        TreeNode right=deleteNode.right;

        if(right.left==null){
            deleteNode.val=right.val;
            deleteNode.right=right.right;
            return deleteNode;
        }
        TreeNode node=right;
        while(node.left!=null && node.left.left!=null){
            node=node.left;
        }
        deleteNode.val=node.left.val;
        node.left=node.left.right;
        return deleteNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node=root,pre = null;
        int flag=0;

        while (node!=null){

            if(node.val==key){
                node=findMin(node);
                if(flag==0) return node;
                if(flag==1) pre.left=node;
                else pre.right=node;
                return root;
            }
            pre=node;
            if(node.val<key){
                node=node.right;
                flag=2;
            }
            else {
                node=node.left;
                flag=1;
            }

        }
        return root;
    }
}
