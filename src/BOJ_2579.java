import java.io.*;

// 계단 오르기
public class BOJ_2579 {
    static int[] stairs;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 계단 수 입력받기
        int N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new Integer[N + 1];

        // 계단에 쓰인 수 입력받기
        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0]; // 디폴트값이 null임 0으로 초기화
        dp[1] = stairs[1];

        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        bw.write(String.valueOf(find(N)));
        bw.close();
    }

    static int find(int N) {
        // 아직 탐색하지 않은 계단이면
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + stairs[N - 1]) + stairs[N];
        }

        return dp[N];
    }
}

/*
    1. 계단을 오를 때 한 계단 또는 두 계단을 오를 수 있음
    2. 연속된 3개의 계단을 밟으면 안됨 (한 계단씩 올라갈 때 최대 연속으로 2번만 한 계단씩 가능)
    3. 마지막 계단은 꼭 밟아야 함

    이전 계단을 밟은 상태인지 알 수 없음, 조건을 충족하지 못할 수 있기에
    연속된 계단의 경우의 수는 재귀호출이 아니라 이미 입력받은 배열의 값을 더해줌
    => 두 계단 전의 경우(N - 2)와 직전 계단(N - 1)을 밟고 그 이전에는 두 계단 이전의 경우(N - 3)에서
       연속되지 않는 위치인 N - 2 와 N - 3에 대해서만 재귀호출을 해주어야 함
 */