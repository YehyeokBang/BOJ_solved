import java.io.*;
import java.util.StringTokenizer;

// 유기농 배추
public class BOJ_1012 {
    static int M; // 가로 길이
    static int N;  // 세로 길이
    static int[][] ground; // 땅
    static boolean[][] checked; // 지렁이 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 횟수

        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            ground = new int[N][M];
            checked = new boolean[N][M];

            int K = Integer.parseInt(st.nextToken()); // 배추 개수
            // 배추 위치 저장
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }

            // 필요한 배추흰지렁이
            int minWorm = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(ground[i][j] == 1 && !checked[i][j]) {
                        dfs(i, j);
                        minWorm++;
                    }
                }
            }
            sb.append(minWorm).append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 인접한 배추 탐색, 인접한 배추들은 1개의 지렁이만 필요
    static void dfs(int row, int col) {
        checked[row][col] =true;

        // 상
        if(row > 0) {
            if(ground[row - 1][col] == 1 && !checked[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 하
        if(row < N - 1) {
            if(ground[row + 1][col] == 1 && !checked[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 좌
        if(col > 0) {
            if(ground[row][col - 1] == 1 && !checked[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 우
        if(col < M - 1) {
            if(ground[row][col + 1] == 1 && !checked[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
    }
}
