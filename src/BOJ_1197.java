import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 스패닝 트리
public class BOJ_1197 {
    static int total; // 최소 스패닝 트리의 가중치 합
    static List<Node>[] list; // 인접 리스트
    static boolean[] visited; // 방문 여부

    // 간선 정보를 담는 클래스
    static class Node implements Comparable<Node> {
        int to; // 간선의 정점
        int value; // 간선의 가중치

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수, 간선의 개수 입력
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성 및 초기화
        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        // 1번 정점부터 시작
        prim(1);

        // 결과 출력
        System.out.println(total);
    }

    static void prim(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int node = p.to;
            int weight = p.value;

            if (visited[node]) continue;
            // 선택한 간선의 정점으로부터 가장 낮은 가중치 갖는 정점 선택
            visited[node] = true;
            total += weight;

            for (Node next : list[node]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
    }
}