import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS
public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a, b 입력
        String a = br.readLine();
        String b = br.readLine();

        // dp[i][j] = a의 i번째 문자열까지와 b의 j번째 문자열까지의 LCS
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        // a의 i번째 문자열까지와 b의 0번째 문자열까지의 LCS는 0
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = 0;
        }

        // a의 0번째 문자열까지와 b의 j번째 문자열까지의 LCS는 0
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = 0;
        }

        // a의 i번째 문자열까지와 b의 j번째 문자열까지의 LCS
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                // a의 i번째 문자열과 b의 j번째 문자열이 같으면
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // a의 i번째 문자열까지와 b의 j번째 문자열까지의 LCS는
                    // a의 i - 1번째 문자열까지와 b의 j - 1번째 문자열까지의 LCS + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // a의 i번째 문자열까지와 b의 j번째 문자열까지의 LCS는
                    // a의 i - 1번째 문자열까지와 b의 j번째 문자열까지의 LCS와
                    // a의 i번째 문자열까지와 b의 j - 1번째 문자열까지의 LCS 중 큰 값
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // a의 마지막 문자열까지와 b의 마지막 문자열까지의 LCS 출력
        System.out.println(dp[a.length()][b.length()]);
    }
}