import java.io.*;
import java.util.StringTokenizer;

// 스티커
public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스의 개수 t 입력
        int t = Integer.parseInt(br.readLine());

        // t개의 테스트 케이스 입력
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            // 스티커 점수를 저장
            int[][] sticker = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }

            // 출력
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}