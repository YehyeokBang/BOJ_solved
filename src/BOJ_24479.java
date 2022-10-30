import java.io.*;
import java.util.*;

// 알고리즘 수업 - 깊이 우선 탐색 1
public class BOJ_24479 {
    static StringBuilder sb = new StringBuilder();
    static int[] result = new int [100001];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        // N: 정점 개수, M: 간선 개수, R: 시작 정점
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] graph = new LinkedList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 모든 간선들을 오름차순으로 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 방문 여부
        boolean[] visited = new boolean[N + 1];

        dfs(R, graph, visited);

        // i번째 정점이 몇 번째로 탐색되었는지, 탐색되지 못한다면 0을 출력
        for(int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void dfs(int R, LinkedList<Integer>[] graph, boolean[] visited) {
        Iterator<Integer> iterator = graph[R].listIterator();

        // 시작 정점은 무조건 방문
        visited[R] = true;
        result[R] = ++count;

        while (iterator.hasNext()) {
            int w = iterator.next();

            // 아직 방문하지 않은 곳이라면 dfs 호출
            // graph나 visited를 매개변수로 똑같이 넘겨줌
            if(!visited[w]) {
                dfs(w, graph, visited);
            }
        }
    }
}
