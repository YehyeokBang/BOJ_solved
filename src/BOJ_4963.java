import java.io.*;
import java.util.StringTokenizer;

// 섬의 개수
public class BOJ_4963 {
    static int w; // 지도의 너비
    static int h; // 지도의 높이
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부
    static int island; // 섬의 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 0 0 을 입력받으면 종료
            if(w == 0 && h == 0) {
                break;
            }

            // 입력받은 크기만큼 배열 초기화
            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 정보 저장
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 섬의 개수 탐색
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        island++;
                    }
                }
            }
            sb.append(island).append("\n");
            island = 0;
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        // 북
        if(row > 0) {
            if(map[row - 1][col] == 1 && !visited[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 북서
        if(row > 0 && col > 0) {
            if(map[row - 1][col - 1] == 1 && !visited[row - 1][col - 1]) {
                dfs(row - 1, col - 1);
            }
        }
        // 남
        if(row < h - 1) {
            if(map[row + 1][col] == 1 && !visited[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 동남
        if(row < h - 1 && col < w - 1) {
            if(map[row + 1][col + 1] == 1 && !visited[row + 1][col + 1]) {
                dfs(row + 1, col + 1);
            }
        }
        // 서
        if(col > 0) {
            if(map[row][col - 1] == 1 && !visited[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 서남
        if(row < h - 1 && col > 0) {
            if(map[row + 1][col - 1] == 1 && !visited[row + 1][col - 1]) {
                dfs(row + 1, col - 1);
            }
        }
        // 동
        if(col < w - 1) {
            if(map[row][col + 1] == 1 && !visited[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
        // 북동
        if(row > 0 && col < w - 1) {
            if(map[row - 1][col + 1] == 1 && !visited[row - 1][col + 1]) {
                dfs(row - 1, col + 1);
            }
        }
    }
}