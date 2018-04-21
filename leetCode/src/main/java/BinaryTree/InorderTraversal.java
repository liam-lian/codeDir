package BinaryTree;

import _entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
 *   Created by zview@qq.com on 2018/4/18.
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> res=new ArrayList<>();
        TreeNode t=root;
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        while (t!=null || !stack.isEmpty()){

            while (t!=null){
                stack.push(t);
                t=t.left;
            }

            t=stack.pop();
            res.add(t.val);
            t=t.right;
        }
        return res;
    }
}
