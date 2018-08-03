/*
 *   Created by zhuang.lian@qunar.com on 18-6-28.
 */

/*
        URL url=new URL("http://www.lvcang.cn/jingqu/Services/QunarAPIService.ashx");  返回500
*/
import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Http {
    public static void main(String[] args) throws IOException {


//        Http.healthCheck("http://www.52uku.net/webservice.asmx/ServiceApiForQunar","POST");
//        System.exit(0);

        int count=0;
        ExecutorService executorService=Executors.newFixedThreadPool(20);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/zhuanglian/tt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while ((line = reader.readLine()) != null) {
             System.out.println(line+(count++));
            String finalLine = line;
            executorService.submit(()->{

            try {
                Http.healthCheck(finalLine,"POST");
            } catch (IOException e) {
                e.printStackTrace();
            }
            });
        }
        executorService.shutdown();
//        等待直到所有任务完成
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        write2File();
        reader.close();
    }


    private static ConcurrentHashMap<String, String> keepAliveSuccess = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> keepAliveException = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> keepAliveFail = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> keep200NotSuccess = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String, String> telnetFail = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String, String> visit200 = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> visitException = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> visitFail = new ConcurrentHashMap<>();

    public static boolean healthCheck(String URL, String Method) throws IOException {

        if(!URL.startsWith("http")){
            URL="http://"+URL;
        }
        URL url=new URL(URL.trim());
        keepalive(url,Method);
        testByResponseCode(url,Method);
        testTelnet(url);
        return false;
    }

    private static boolean keepalive(URL url, String Method) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(Method);
            conn.setConnectTimeout(1000);
            conn.setReadTimeout(1000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            conn.setDoOutput(true);

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.write("method=testAlive&requestParam=Are you alive?".getBytes("UTF-8"));
            os.flush();
            os.close();
            conn.connect();
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                byte[] by = new byte[102400];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                // 将内容读取内存中
                int len, totalLen = 0;
                while ((len = is.read(by)) != -1) {
                    bos.write(by, 0, len);
                    totalLen += len;
                }
                is.close();
                String reStr = new String(by, 0, totalLen);

                if (reStr.trim().equals("alive") || reStr.trim().equals("\"alive\"")) {
                    keepAliveSuccess.put(url.toString(),"");
                    return true;
                }else {
                    keep200NotSuccess.put(url.toString(),reStr);
                }
            }else {
                keepAliveFail.put(url.toString(),String.valueOf(code));
            }
        } catch (IOException e) {
                keepAliveException.put(url.toString(),e.getLocalizedMessage());
        } finally {
            conn.disconnect();
        }
        return false;
    }

    private static boolean testByResponseCode(URL url, String Method) {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(Method);
            conn.setConnectTimeout(1000);
            conn.setRequestProperty("Content-Length", "0");
            conn.setDoOutput(true);
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.write("".getBytes("UTF-8"), 0, 0);
            os.flush();
            os.close();

            String responseCode = String.valueOf(conn.getResponseCode());
            if(responseCode.equals("200")){
                visit200.put(url.toString(),"");
                return true;
            }else {
                visitFail.put(url.toString(),responseCode);
            }
        } catch (IOException e) {
            visitException.put(url.toString(),e.getLocalizedMessage());
        }
        return false;
    }

    private static boolean testTelnet(URL url) {
        TelnetClient telnetClient = new TelnetClient();
        telnetClient.setConnectTimeout(1000);
        int port = 80;
        try {
            if (url.getPort() >= 0) {
                port = url.getPort();
            }
            telnetClient.connect(url.getHost(), port);
            return true;
        } catch (IOException e) {
            telnetFail.put(url.toString(),e.getLocalizedMessage());
            return false;
        } finally {
            try {
                telnetClient.disconnect();
            } catch (IOException e) {
            }
        }
    }

    public static void write2File(){


        System.out.println("=================keepAliveSuccess================="+keepAliveSuccess.size());
        for(String key:keepAliveSuccess.keySet()){
            System.out.println(key);
        }
        System.out.println("=================keepAliveException================="+keepAliveException.size());
        for(Map.Entry entry:keepAliveException.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("=================keep200NotSuccess================="+keep200NotSuccess.size());
        for(Map.Entry entry:keep200NotSuccess.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("=================keepAliveFail================="+keepAliveFail.size());
        for(Map.Entry entry:keepAliveFail.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }




        System.out.println("=================telnetFail================="+telnetFail.size());
        for(Map.Entry entry:telnetFail.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("=================visit200================="+visit200.size());
        for(String key:visit200.keySet()){
            System.out.println(key);
        }
        System.out.println("=================visitException================="+visitException.size());
        for(Map.Entry entry:visitException.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("=================visitFail================="+visitFail.size());
        for(Map.Entry entry:visitFail.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
