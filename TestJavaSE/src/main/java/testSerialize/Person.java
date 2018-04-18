package testSerialize;
/*
 *   Created by zview@qq.com on 18-4-15.
 */

import java.io.*;

public class Person implements Serializable,Cloneable{

    int age;
    String name;
    Address address;
    int a[]=new int[]{1,2,3};

    public Person(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person o=(Person) super.clone();
        o.a=o.a.clone();
        return o;
    }

    public static void main(String[] args) throws IOException, CloneNotSupportedException, ClassNotFoundException {



        Person p=new Person(12,"zz",new Address("bj"));
//        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("/home/zview/aa.bin"));
//        o.writeObject(a);
//
//        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("/home/zview/aa.bin"));
//        int[] pp= (int[]) inputStream.readObject();

        Person pp= (Person) p.clone();
        p.a[2]=100;
        System.out.println(pp.a[2]);

        int arr[]=new int[]{1,2,3};
        int arr1[]=new int[]{1,2,3};
        System.out.println(arr.getClass().getName());
        System.out.println(p);

//        Person pp= (Person) p.clone();
//        System.out.println(pp.address);
//        System.out.println(p.address);
//        System.out.println(pp.equals(p));
    }
}
