import java.io.*;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class BOJ_11724 {
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 방향 없는 그래프이기에 1 2와 2 1은 똑같음
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = 1;
        }

        int connectedComponent = 0; // 연결 요소의 개수
        // 1 ~ N개의 점을 살펴보는데 그 중에서 방문하지 않은 점을 탐색함
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                // 방문하다가 더 이상 연결되어 있지 않으면 나머지는 연결된 요소가 아님
                // 따라서 연결요소의 개수 증가
                connectedComponent++;
            }
        }

        // 출력
        bw.write(String.valueOf(connectedComponent));
        bw.close();
    }

    // dfs 탐색
    static void dfs(int v) {
        // 방문한 점 표시
        visited[v] = true;

        // 방문한 점과 연결된 점이 있는지 찾아보고 있으면 탐색
        for(int i = 1; i <= N; i++) {
            if(graph[v][i] == 1) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
        }
    }
}