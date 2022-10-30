import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// 경찰차
public class BOJ_2618 {
    static StringBuilder sb; //결과 저장
    static int N; // 도로의 개수
    static int W; // 사건의 개수
    static int[][] event = new int[1002][2]; // [사건 번호][0 or 1] 0:xPos / 1:yPos
    static int[][] dp;
    // dp[i][j]:1번 경찰차가 i번째 사건 처리했고, 2번 경찰차가 j번째 사건을 처리했을 때, 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        for(int i=1; i<=W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            event[i][0] = Integer.parseInt(st.nextToken());
            event[i][1] = Integer.parseInt(st.nextToken());
        }

        // 배열 dp -1로 초기화, -1이라면 아직 계산된 적이 없는 것
        dp = new int[W+1][W+1];
        for(int i=0; i<=W; i++) {
            for(int j=0; j<=W; j++) {
                dp[i][j] = -1;
            }
        }

        // 사건을 해결하기 위해 움직이는 값의 최솟값
        sb.append(solve(0, 0)).append('\n');

        // 최단 경로에서 각 사건마다 도착한 경찰차 종류(1 or 2)
        getPath(0, 0);

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 두 대의 경찰차가 이동하는 거리의 합의 최솟값을 구하는 메소드
    static int solve(int police_1, int police_2) {
        // W:사건의 수, 사건의 수만큼 이미 계산을 완료했을 경우
        if(police_1 == W || police_2 == W) {
            return 0;
        }

        // 이미 1번 경찰차가 i번째 사건 처리했고, 2번 경찰차가 j번째 사건을 처리한 경우를 계산한 적 있는 경우
        if(dp[police_1][police_2] != -1) {
            return dp[police_1][police_2];
        }

        // 다음 순서의 사건 번호, 현재 해결한 사건(경찰차1 or 경찰차2)들 중 가장 큰 사건 번호에 1 증가한 값
        int next = Math.max(police_1, police_2) + 1;

        int police_1_distance, police_2_distance; // 경찰차 1, 2의 거리
        // 현재까지 경찰차 1의 거리
        if(police_1 == 0) {
            police_1_distance = getDistance(1, 1, event[next][0], event[next][1]);
        }
        else {
            police_1_distance = getDistance(event[police_1][0], event[police_1][1], event[next][0], event[next][1]);
        }

        // 현재까지 경찰차 2의 거리
        if(police_2 == 0) {
            police_2_distance = getDistance(N, N, event[next][0], event[next][1]);
        }
        else {
            police_2_distance = getDistance(event[police_2][0], event[police_2][1], event[next][0], event[next][1]);
        }

        // 경찰차 1이 출동할 경우
        int police_1_solved = police_1_distance + solve(next, police_2);
        // 경찰차 2가 출동할 경우
        int police_2_solved = police_2_distance + solve(police_1, next);

        // 경우를 비교하고 가장 적게 움직이는 경우의 값을 저장
        return dp[police_1][police_2] = Math.min(police_1_solved, police_2_solved);
    }

    // (x1, y1)과 (x2, y2)의 거리(절댓값) 구하기
    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    // 최단 경로로 사건 현장에 도착할 때, 각 사건마다 도착한 경찰차를 알아내는 메소드 (경로 찾기), solve()와 유사
    static void getPath(int police_1, int police_2) {
        // 알아보는 사건의 수가 넘어설 경우
        if(police_1 == W || police_2 == W) {
            return;
        }

        int next = Math.max(police_1, police_2) + 1; // 다음 순서의 사건 번호

        int police_1_distance, police_2_distance; // 경찰차 1, 2의 거리
        // 현재까지 경찰차 1의 거리
        if(police_1 == 0) {
            police_1_distance = getDistance(1, 1, event[next][0], event[next][1]);
        }
        else {
            police_1_distance = getDistance(event[police_1][0], event[police_1][1], event[next][0], event[next][1]);
        }

        // 현재까지 경찰차 2의 거리
        if(police_2 == 0) {
            police_2_distance = getDistance(N, N, event[next][0], event[next][1]);
        }
        else {
            police_2_distance = getDistance(event[police_2][0], event[police_2][1], event[next][0], event[next][1]);
        }

        // 이미 solve()로 필요한 dp 값은 다 구함
        // dp 값: 현재 상태에서 무슨 경찰차든 고르면 그 지점까지의 최소 경로값
        // distance(1 or 2): 무슨 경찰차든 고르면 고른 경찰차와 현재 사건의 거리
        // 위 두가지를 더한 값이 작은 것을 골라야 최단 경로로 가는 방법이다.
        if (dp[next][police_2] + police_1_distance < dp[police_1][next] + police_2_distance) {
            sb.append("1\n");
            getPath(next, police_2);
        } else {
            sb.append("2\n");
            getPath(police_1, next);
        }
    }
}
