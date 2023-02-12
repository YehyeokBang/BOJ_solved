import java.io.*;

/*
   점화식: t(n) = t(0) * t(n-1) + t(1) * t(n-2) + ... + t(n-1) * t(0)

   예시:
   t(1) = t(0) * t(0) = 1
   t(2) = t(0) * t(1) + t(1) * t(0) = 2
   t(3) = t(0) * t(2) + t(1) * t(1) + t(2) * t(0) = 5
*/

// 점화식
public class BOJ_13699 {
    static long[] dp = new long[36]; // int 범위를 벗어날 수 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        dp[0] = 1;

        // 점화식
        for(int i = 0; i <= N; i++) {
            int index = i / 2;

            for(int j = 0; j < index; j++) {
                dp[i] += 2 * (dp[j] * dp[i - 1 - j]);
            }

            if(i % 2 == 1) {
                dp[i] += dp[i/2] * dp[i/2];
            }
        }

        // 출력
        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}