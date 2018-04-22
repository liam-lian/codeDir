import java.io.*;

public class MyClassLoader extends ClassLoader{


    private String path;

    public MyClassLoader(String path){
        this.path=path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        FileInputStream fis;
        ByteArrayOutputStream bao=null;
        try {
            fis=new FileInputStream(path+File.separator+name+".class");
            bao=new ByteArrayOutputStream();
            byte buffer[]=new byte[100];
            int readLen;
            while ((readLen = fis.read(buffer)) > 0){
                bao.write(buffer,0,readLen);
            }
        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException("找不到文件");
        }catch (IOException ignored){}

        //.class文件的内容,查找类文件的过程
        byte[] classData=bao.toByteArray();
        //define完成类加载的过程
        return super.defineClass(classData,0,classData.length);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader loader=new MyClassLoader("/home/zview");
        System.out.println(loader.getClass().getClassLoader());


        ClassLoader tempLoader=loader;
        while (tempLoader!=null){
            System.out.println(tempLoader);
            tempLoader=tempLoader.getParent();
        }

        Class<?> testclass=loader.findClass("testClass");
        System.out.println(testclass.getClassLoader());

        //尝试调用out()方法
        testclass.getMethod("out").invoke(testclass.newInstance());
    }
}
