package BinaryTree;

import _entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 *   Created by zview@qq.com on 2018/4/18.
 */
public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res=new ArrayList<>();

        if(root==null) return res;

        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> levelRes=new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode  tmp=queue.poll();
                levelRes.add(tmp.val);
                if(tmp.left!=null) queue.offer(tmp.left);
                if(tmp.right!=null) queue.offer(tmp.right);
            }
            res.add(levelRes);
        }
        return res;
    }
}
