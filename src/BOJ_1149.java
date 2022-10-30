import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// RGB 거리
public class BOJ_1149 {
    static int[][] cost; // 각 집마다 색을 칠하는 비용 ( 빨:0, 초:1 파:2 )
    static int[][] dp; // 각 포인트별 최소 비용 루트의 총 비용 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 맨 밑줄에 cost 맨 밑줄 삽입
        for(int i=0; i<3; i++) {
            dp[N - 1][i] = cost[N - 1][i];
        }

        bw.write(String.valueOf(minCoast(N - 1, 0)));
        bw.close();
    }

    static public int minCoast(int level, int index) {
        // 맨 밑부터 최단 경로값을 저장하며 올라가는 구조
        dp[level - 1][index] = Math.min(dp[level][(index + 1) % 3], dp[level][(index + 2) % 3]) + cost[level - 1][index];
        dp[level - 1][(index + 1) % 3] = Math.min(dp[level][index], dp[level][(index + 2) % 3]) + cost[level - 1][(index + 1) % 3];
        dp[level - 1][(index + 2) % 3] = Math.min(dp[level][index], dp[level][(index + 1) % 3]) + cost[level - 1][(index + 2) % 3];

        // 맨 위라면 더 이상 진행하지 않음
        if(level > 1) {
            minCoast(level - 1, index);
        }

        // 결국 dp 배열 최상단에는 각각 도착 지점으로 오는 루트 중 최단 비용이 저장되어 있음
        // 그 중 최소값이 결국 모든 루트의 최솟값
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}
