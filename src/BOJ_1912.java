import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연속합
public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수의 개수 n 입력
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        // n개의 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 각 위치에서 합의 최댓값을 저장할 배열
        int[] dp = new int[n];
        // seq[0] 자리의 입장에서는 자기 자신을 더하는 것이 최댓값임
        dp[0] = seq[0];

        // 이전 결과를 더하는 것이 큰지 그냥 현재 자리의 값이 큰지 비교하고 dp 배열에 저장
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
        }

        // dp 배열에서 최댓값 출력
        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}