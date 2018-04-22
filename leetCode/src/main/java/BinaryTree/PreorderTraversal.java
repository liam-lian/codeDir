package BinaryTree;

import _entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
 *   Created by zview@qq.com on 2018/4/18.
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {


        List<Integer> res=new ArrayList<>();
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();

        TreeNode t=root;
        while (!stack.isEmpty() || t!=null){
            while (t!=null){
                res.add(t.val);
                if(t.right!=null){
                    stack.push(t.right);
                }
                t=t.left;
            }
            if(!stack.isEmpty())
                t=stack.pop();
        }
        return res;
    }
}
