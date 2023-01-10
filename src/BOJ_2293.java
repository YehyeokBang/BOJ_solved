import java.io.*;
import java.util.StringTokenizer;

// 동전 1
public class BOJ_2293 {
    static int n; // 서로 다른 동전의 개수
    static int k; // 원하는 가치(가격)
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        // dp[i] = j 라고 하면 i: 금액, j: i원을 만드는데 가능한 경우의 수
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        // 출력
        bw.write(String.valueOf(dp[k]));
        bw.close();
    }
}
