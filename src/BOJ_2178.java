import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class BOJ_2178 {
    static int N; // 세로 칸
    static int M; // 가로 칸
    static int[][] maze; // 미로
    static boolean[][] visited; // 방문 여부
    static int[] dx = { -1, 1, 0, 0 }; //x 방향 배열: 상, 하 (dx, dy를 같은 인덱스로 사용하면 상, 하, 좌, 우)
    static int[] dy = { 0, 0, -1, 1 }; //y 방향 배열: 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 미로 크기 입력
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 입력
        maze = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }
        // [0][0] 위치에 방문여부 true로 하고 탐색 시작
        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0, 0);

        // 결국 마지막 칸의 담긴 이동 칸 수가 최소의 칸 수임, 출력
        bw.write(String.valueOf(maze[N - 1][M - 1]));
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        // 비어있는 queue 가 될 때까지
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                // 방향 배열을 이용해서 큐에 담긴 좌표를 기준으로 상, 하, 좌, 우를
                // 기준에 따라 큐에 넣을지 말지 체크함
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 미로의 크기를 넘어서면 탐색 안함
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                // 이미 방문한 곳이거나 갈 수 없는 곳(0)이라면 탐색 안함
                if(visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }

                // 기준에 부합하는 좌표들은 다시 큐에 삽입
                queue.add(new int[] {nextX, nextY});

                // 이전 탐색까지의 이동 칸수 + 1해서 nextXY 칸 까지 몇 칸째인지 저장
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                // 그리고 저장한 칸은 방문 표시
                visited[nextX][nextY] = true;
            }
        }
    }
}