package math;
/*
 *   Created by zview@qq.com on 18-4-22.
 */

public class PoorPigs {

    /*
    * 这里实际上是一个编码的问题
    * 使用n只猪对于b个桶进行编码
    * 假设每一只猪能够进行x轮测试,那么每一只猪就是能够进行一个(x+1)阶数的编码
    *
    * 例如每个猪能够测试四轮,那么编码值为0-4,分别表示第i轮给猪服用对应的桶里的水
    *
    * 因此结果就是  n^x>=b
    * 转化成Java实现,就是两个log值相除然后向上取整
    * */


    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
       return (int)Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie+1));
    }
}
