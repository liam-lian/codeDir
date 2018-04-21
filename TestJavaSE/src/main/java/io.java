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
        if (f.isDirectory()) {
            File fileList[]=f.listFiles();
            if(fileList==null) return;
            for (File temp : fileList) {
                _walkDirectory(temp, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }

        Set<Integer> s=new HashSet<>();

    }

}
