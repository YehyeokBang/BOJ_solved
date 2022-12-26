import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class BOJ_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 맵 사이즈 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시작지점과 도착지점이 같을 경우, 바로 도착
        if(N - 1 == 0 && M - 1 == 0){
            bw.write("1");
            bw.close();
            return;
        }

        // 탐색에 이용, 상 하 좌 우
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 맵 정보 입력
        char[][] map = new char[N][M]; // 맵 정보 저장 배열
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[][] dist = new int[N][M]; // 거리 측정 배열
        boolean[][][] visited = new boolean[2][N][M]; // 벽을 부순 여부에 따라 방문 여부 기록
        Queue<int[]> queue = new LinkedList<>();

        // 시작 (x좌표, y좌표, crash 여부)
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            // 현재 위치
            int[] now = queue.poll();

            // 상,하,좌,우 탐색
            for(int i = 0; i < 4; i++){
                int nX = now[0] + dx[i]; // 현재 x좌표
                int nY = now[1] + dy[i]; // 현재 y좌표

                // 맵 크기를 넘어가면 continue
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                // 다음 칸이 벽일 경우
                if (map[nX][nY] == '1') {
                      // crash 여부 && 벽 방문 여부
                    if(now[2] == 0 && !visited[1][nX][nY]) {
                        visited[now[2]][nX][nY] = true;
                        dist[nX][nY] = dist[now[0]][now[1]] + 1; // 이전 구간까지의 거리 + 1
                        queue.offer(new int[] {nX, nY, 1});
                    }
                }
                // 벽이 아닐 경우
                else{
                    if(!visited[now[2]][nX][nY]) {
                        // now[2]: 벽을 부순 적이 있으면 1, 없으면 0으로 방문 처리
                        visited[now[2]][nX][nY] = true;
                        dist[nX][nY] = dist[now[0]][now[1]] + 1; // 이전 구간까지의 거리 + 1
                        queue.offer(new int[] {nX, nY, now[2]});
                    }
                }

                // 도착
                if(nX == N - 1 && nY == M - 1) {
                    bw.write(String.valueOf(dist[nX][nY] + 1));
                    bw.close();
                    return;
                }
            }
        }

        // 불가능한 경우, -1 출력
        bw.write("-1");
        bw.close();
    }
}