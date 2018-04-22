package innerClassTest;
/*
 *   Created by zview@qq.com on 18-4-14.
 */

public class Sequence<T> {

    private T  vals[];
    private int index;
    private int capality;
    public boolean add(T val){
        if(index==capality) return false;
        vals[index++]=val;
        return true;
    }
    public Sequence(int capality) {
        this.capality = capality;
    }

    public Iteratoor iterator(){
        return new SequenceIteratoor();
    }

    private class SequenceIteratoor implements Iteratoor<T>{
        private int index;
        @Override
        public boolean hasMore() {
            //前者指向内部类的index,后者指向外部类的index
            return this.index<Sequence.this.index;
        }
        @Override
        public T next() {
            return vals[this.index];
        }

        @Override
        public void reset() {
            index=0;
        }
    }
}
