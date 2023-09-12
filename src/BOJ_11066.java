import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 입력
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스 반복
        for (int tc = 0; tc < t; tc++) {
            int k;
            int[] novel;
            int[] sum;
            int[][] dp;

            // 소설의 장 수 입력
            k = Integer.parseInt(br.readLine());
            novel = new int[k + 1];
            dp = new int[k + 1][k + 1];
            sum = new int[k + 1];

            // 소설의 장별 크기 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + novel[i];
            }

            // dp[i][j] = i부터 j장까지 합치는 비용
            // dp[i][i] = novel[i]
            // dp[i][i + 1] = novel[i] + novel[i+1]
            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            // 출력
            System.out.println(dp[1][k]);
        }
    }
}