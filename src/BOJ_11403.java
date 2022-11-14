import java.io.*;
import java.util.StringTokenizer;

// 경로 찾기
public class BOJ_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 정점의 개수: N, 가중치 없는 방향 그래프: graph
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        // 가중치 없는 그래프 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 거쳐가는 정점, i -> j == i -> k -> j 같은 의미
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1; // 경로 찾으면 바로 체크
                    }
                }
            }
        }

        // 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}