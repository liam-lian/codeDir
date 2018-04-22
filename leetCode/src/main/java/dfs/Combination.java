package dfs;
/*
 *   Created by zview@qq.com on 18-4-13.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private List<List<Integer>> res;

    @Test
    public void test(){
        combine(4,2);
        System.out.println(res.size());
    }

    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        dfs(1,k,new ArrayList<>(),n);
        return res;

    }
    private void dfs(int i,int k,List<Integer> list,int n){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(;i<=n-k+list.size()+1;i++){
            list.add(i);
            dfs(i+1,k,list,n);
            list.remove(list.size()-1);
        }
    }
}
