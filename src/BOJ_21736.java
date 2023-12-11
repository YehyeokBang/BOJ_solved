import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해
public class BOJ_21736 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visit;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int cnt = dfs(new Pair(x, y), 0);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static int dfs(Pair pair, int cnt) {
        int cx = pair.x;
        int cy = pair.y;

        if (map[cx][cy] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (valid(nx, ny)) {
                visit[nx][ny] = true;
                cnt = dfs(new Pair(nx, ny), cnt);
            }

        }

        return cnt;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x <= N - 1 && y >= 0 && y <= M - 1 && map[x][y] != 'X' && !visit[x][y];
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
