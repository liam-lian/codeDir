package hash;

/*
 *   Created by zhuang.lian@qunar.com on 18-6-25.
 */

import java.util.*;

/*
*   要求能够O(1)复杂度之内插入、删除元素，并且能够任意得到一个随机的元素
*
*  O(1)复杂度删除和插入元素肯定要使用hash表
*  O(1)负责度得到随机的一个元素则需要ArrayList来实现
*  需要共同实现上面的功能，可以将两个结构联合起来一起使用
*  那么现在的问题就是:
*  获得随机元素通过ArrayList拿到就可以了
*  插入元素的时候放到ArrayList最后就好
*  但是删除元素ArrayList的复杂度是O(n).其实如果不考虑元素的位置的话，只需要将元素swap到最后然后删掉就可以了
*  为了保持两组元素之间的同步，在HashMap中保存对应元素在List中的索引
* */
public class RandomizedSet {

    private List<Integer> list=new ArrayList<>();
    private Map<Integer,Integer> map=new HashMap<>();
    private Random random=new Random();

    public RandomizedSet() {

    }
    public boolean insert(int val) {

        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;
    }

    /*
    * ArrayList的删除不是O(1)的
    * 1.将删除的位置和末尾元素交换之后在删除末尾元素
    * 2.交换之后原来的末尾元素在map中的val(即索引)要更新
    * 3.对于删除的元素就是末尾元素本身的情况需要特别分析
    * */
    public boolean remove(int val) {

        if(map.containsKey(val)){
            int index=map.remove(val);
            if(index!=list.size()-1) {
                list.set(index, list.get(list.size() - 1));
                map.put(list.get(list.size() - 1), index);
            }
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
