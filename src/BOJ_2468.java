import java.io.*;
import java.util.StringTokenizer;

// 안전 영역
public class BOJ_2468 {
    static int N;
    static int[][] map; // 어떤 지역
    static int[][] test; // 강수량에 따른 결과 테스트 배열
    static boolean[][] visited;
    static int maxSafeArea = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 지역 높이 정보 저장
        map = new int[N][N];
        int maxHeight = 0; // 최고 높이와 강수량이 같으면 모든 지역이 물에 잠김
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }
        // 방문 여부 저장할 배열 초기화
        visited = new boolean[N][N];

        // 비가 1만큼 올 때부터 다 잠길 때까지 반복
        for(int tc = 1; tc <= maxHeight; tc++) {
            test = new int[N][N];

            // tc 만큼 비가 오면 결과가 어떻게 되는지 저장
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    test[i][j] = map[i][j] - tc;
                }
            }

            // tc 만큼 비가 오면 안전한 지역은 몇 개인지 파악
            int safeArea = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(test[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        safeArea++;
                    }
                }
            }

            // 안전한 지역의 최대 개수
            if(maxSafeArea < safeArea) {
                maxSafeArea = safeArea;
            }

            // 사용한 변수 및 배열 초기화
            safeArea = 0;
            visited = new boolean[N][N];
        }

        // 출력
        bw.write(String.valueOf(maxSafeArea));
        bw.close();
    }

    // 깊이 우선 탐색
    static void dfs(int row, int col) {
        visited[row][col] = true;

        // 상
        if(row > 0) {
            if(test[row - 1][col] > 0 && !visited[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 하
        if(row < N - 1) {
            if(test[row + 1][col] > 0 && !visited[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 좌
        if(col > 0) {
            if(test[row][col - 1] > 0 && !visited[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 우
        if(col < N - 1) {
            if(test[row][col + 1] > 0 && !visited[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
    }
}