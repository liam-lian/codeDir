package graph;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */


import java.util.*;

//BFS 宽度优先搜索
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> notVisit=new HashSet<>(wordList);
        wordList.remove(beginWord);
        notVisit.add(endWord);

        ArrayDeque<String> queue=new ArrayDeque<>();
        queue.offerLast(beginWord);

        int heigh=0;
        int lineLimt=1;
        int lineLimtCount=0;

        while (!queue.isEmpty()){
            String cur=queue.pollFirst();

            Iterator<String> iterator=notVisit.iterator();

            while (iterator.hasNext()){
                String s=iterator.next();
                if(isDiatanceOne(cur,s)){
                    if(s.equals(endWord)) return heigh+1;
                    iterator.remove();
                    lineLimtCount++;
                    queue.offerLast(s);
                }
            }
            if(--lineLimt==0){
                lineLimt=lineLimtCount;
                lineLimtCount=0;
                heigh++;
            }
        }

        return 0;
    }
    private boolean isDiatanceOne(String str1,String str2){
        int count=0;
        for (int i = 0; count<=1 && i < str1.length(); i++) {
            if(str1.charAt(i)!=str2.charAt(i)) count++;
        }
        return count<2;
    }
}
