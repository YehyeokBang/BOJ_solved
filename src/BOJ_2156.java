import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 포도주 잔의 개수

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        // 포도주 잔의 양 입력
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp[1] = arr[1], dp[2] = arr[1] + arr[2]
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

        }

        // dp[N]에는 N번째 잔까지의 최대로 마실 수 있는 포도주 양이 저장되어 있다.
        System.out.println(dp[N]);
    }
}
