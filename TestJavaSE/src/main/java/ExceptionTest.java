/*
 *   Created by zhuang.lian@qunar.com on 18-6-27.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {

    public static void main(String[] args) {


        try {
            System.out.println();
            InputStream inputStream=new FileInputStream("");
        } catch (FileNotFoundException e) {
            new Exception("hahah",e).printStackTrace();
        }
    }

}
