import java.io.File;
import java.util.HashSet;
import java.util.Set;

/*
 *   Created by zview@qq.com on 2018/4/18.
 */
public class io {

    public static void main(String[] args) {
        showDirectory(new File("D://zview"));
    }

    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }

    private static void _walkDirectory(File f, int level) {


    }

}
