import java.io.*;
import java.util.StringTokenizer;

// 바닥 장식
public class BOJ_1388 {
    static int N; // 세로 크기
    static int M; // 가로 크기
    static int[][] floor; // 바닥 장식 정보 저장
    static boolean[][] visited; // 탐색할 때 구간 방문 여부 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 필요한 배열 초기화
        floor = new int[N][M];
        visited = new boolean[N][M];

        // 나무 판자 정보 입력
        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                // ( - ) 장식이면 0, ( | ) 장식이면 1
                floor[i][j] = s[j].equals("-") ? 0 : 1;
            }
        }

        // 필요한 나무 판자의 개수
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        // 출력
        bw.write(String.valueOf(count));
        bw.close();
    }

    // 깊이 우선 탐색
    static void dfs(int row, int col) {
        visited[row][col] = true;

        // ( - ) 장식
        if(floor[row][col] == 0) {
            if(col < M - 1) {
                if(floor[row][col + 1] == 0 && !visited[row][col + 1]) {
                    dfs(row, col + 1);
                }
            }
        }
        // ( | ) 장식
        else {
            if(row < N - 1) {
                if(floor[row + 1][col] == 1 && !visited[row + 1][col]) {
                    dfs(row + 1, col);
                }
            }
        }
    }
}