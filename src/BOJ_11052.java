import java.io.*;
import java.util.StringTokenizer;

// 카드 구매하기
public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 구매하려고 하는 카드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        // N개 카드의 가격 arr 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 지불해야 하는 가격의 최댓값 구하기
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        // 출력
        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}