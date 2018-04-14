package innerClassTest;
/*
 *   Created by zview@qq.com on 18-4-14.
 */

public interface Iteratoor<T>{

    public boolean hasMore();
    public T next();
    public void reset();
}
