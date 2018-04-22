package graph;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import _entity.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        //记录搜索的顺序
        List<UndirectedGraphNode> list=new ArrayList<>();
        //hash表，记录原来的点和克隆点的映射关系
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();

        UndirectedGraphNode cloneNode=new UndirectedGraphNode(node.label);
        list.add(node);
        map.put(node,cloneNode);
        int index=0;
        while (index<list.size()){
            UndirectedGraphNode curNode=list.get(index++);
            for(UndirectedGraphNode neighbor:curNode.neighbors){
                if(!map.containsKey(neighbor)){
                    list.add(neighbor);
                    map.put(neighbor,new UndirectedGraphNode(neighbor.label));
                }
            }
        }

        for (UndirectedGraphNode tempNode:list){

            UndirectedGraphNode cloeNode=map.get(tempNode);
            for (UndirectedGraphNode neigh:tempNode.neighbors){
                cloeNode.neighbors.add(map.get(neigh));
            }

        }

        return cloneNode;
    }
}
