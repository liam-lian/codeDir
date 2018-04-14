import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strOne = scanner.nextLine();
        String strTwo = scanner.nextLine();
        System.out.println(dpfunc(strOne, strTwo));
    }
    public static int dpfunc(String strOne, String strTwo) {
        int len1 = strOne.length();
        int len2 = strTwo.length();
        int result = 0;
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (strOne.charAt(i - 1) == strTwo.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

}