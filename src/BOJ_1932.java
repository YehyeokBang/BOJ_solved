import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// 정수 삼각형
public class BOJ_1932 {
    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        // 배열 초기화
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
        for (int i=0; i<N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        bw.write(String.valueOf(maxRoute(0, 0)));
        bw.close();
    }

    static public int maxRoute(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(depth == N - 1) return dp[depth][idx];

        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(maxRoute(depth + 1, idx), maxRoute(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}