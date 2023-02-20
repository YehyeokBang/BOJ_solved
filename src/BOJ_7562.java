import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class BOJ_7562 {
    static int n;
    static int x1,y1;
    static int x2,y2;

    // 8개의 방향 선택을 위한 수
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int[][] visited = new int[301][301];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스의 수 T 입력
        int T = Integer.parseInt(st.nextToken());

        // T만큼 테스트
        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            // 현재 위치의 x, y값 입력
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            // 이동하려는 위치의 x, y값 입력
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            // 방문 여부 초기화
            cleanVisited();

            // 탐색 시작
            bfs(x1, y1, x2, y2);

            // 출력
            System.out.println(visited[x2][y2]);
        }

    }

    public static void bfs(int a,int b,int c,int d){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(a, b));
        visited[a][b] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == c && p.y == d) break;

            for(int i=0;i<8;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny & ny < n &&
                        (visited[nx][ny] == -1 || visited[p.x][p.y] + 1 < visited[nx][ny])
                ){
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    // 방문 여부 초기화
    public static void cleanVisited(){
        for(int i = 0;i <= 300; i++)
            for(int j = 0; j <= 300; j++)
                visited[i][j] = -1;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}