import java.io.*;
import java.util.StringTokenizer;

// 파스칼의 삼각형
public class BOJ_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 정수 n, k 입력
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 값을 저장할 dp 테이블
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 1;

        // 점화식: dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        // 출력
        bw.write(String.valueOf(dp[n][k]));
        bw.close();
    }
}