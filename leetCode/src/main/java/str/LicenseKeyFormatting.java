package str;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class LicenseKeyFormatting{

        public String licenseKeyFormatting(String S, int K) {

            S=S.replaceAll("-","").toUpperCase();
            if(S.length()==0) return "";
            int fistSlice=S.length()%K;
            StringBuilder stringBuilder=new StringBuilder();
            if(fistSlice>0) {
                stringBuilder.append(S, 0, fistSlice);
                stringBuilder.append('-');
            }
            for (int i = fistSlice; i < S.length(); i+=K) {
                stringBuilder.append(S,i,i+K);
                stringBuilder.append('-');
            }
            return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        }

    public static void main(String[] args) {
        System.out.println(   new LicenseKeyFormatting().licenseKeyFormatting("qqqq-asd-w",3));
     ;
    }
}
