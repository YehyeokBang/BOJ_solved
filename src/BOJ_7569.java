import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class BOJ_7569 {
    static int M, N, H; // 가로, 세로, 높이
    static int[][][] box; // 토마토 상자
    static boolean[][][] visited; // 방문 여부
    static Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
    static int[] dx = {0, 0, 1, -1, 0, 0}; // 상 하 좌 우 위 아래
    static int[] dy = {1, -1, 0, 0, 0, 0}; // 상 하 좌 우 위 아래
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 상 하 좌 우 위 아래

    public static void main(String[] args) throws IOException {
        // 토마토 상자의 크기 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M]; // visited 배열 초기화

        // 토마토 상자의 정보 입력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k, 0}); // 일수 정보 추가
                    }
                }
            }
        }

        // 토마토를 익히는 최소 일수 구하고, 모든 토마토가 익었는지 확인
        int days = bfs();
        System.out.println(checkAllRipe() ? days : -1);
    }

    static int bfs() {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            // 큐에서 토마토 정보 꺼내기
            int[] tomato = queue.poll();
            int x = tomato[0];
            int y = tomato[1];
            int z = tomato[2];
            int days = tomato[3];

            maxDays = Math.max(maxDays, days); // 최대 일수 갱신

            visited[x][y][z] = true; // 방문 처리

            // 토마토 익히기 (6방향)
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                // 상자의 범위를 벗어나지 않고, 방문하지 않았고, 토마토가 없는 곳이면 큐에 추가
                if (nx >= 0 && nx < H && ny >= 0 && ny < N && nz >= 0 && nz < M && !visited[nx][ny][nz]) {
                    if (box[nx][ny][nz] == 0) {
                        box[nx][ny][nz] = 1;
                        queue.offer(new int[] {nx, ny, nz, days + 1}); // 일수 정보 추가
                    }
                }
            }
        }

        return maxDays;
    }

    // 모든 토마토가 익었는지 확인하는 메소드
    static boolean checkAllRipe() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0 && !visited[i][j][k]) {
                        return false; // 익지 않은 토마토가 있으면 false 반환
                    }
                }
            }
        }
        return true; // 모든 토마토가 익었으면 true 반환
    }
}