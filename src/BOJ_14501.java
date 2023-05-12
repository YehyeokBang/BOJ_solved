import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일할 수 있는 날 n 입력
        int n = Integer.parseInt(reader.readLine());

        // 소요 시간과 보상을 저장할 배열
        int[] time = new int[n];
        int[] pay = new int[n];

        // 소요 시간과 보상 저장
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n+1];

        // dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
        for (int i = 0; i < n; i++) {
            if (i + time[i] <= n) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
            }
            // 현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 저장
            // 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 저장
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        // 출력
        System.out.println(dp[n]);
    }
}