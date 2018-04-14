package classloader;

import java.util.ArrayList;
import java.util.List;

public class ClassLoaderTest {

    List<Number> list=new ArrayList<>();

    public void add(Number data){
        list.add(data);
    }
    public void addAll(Iterable<? extends Number> iterable){
        for (Number n:iterable){
            list.add(n);
        }
    }


    public static void main(String[] args) {


    }
}
