import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 부모 찾기
public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n 입력
        int n = Integer.parseInt(br.readLine());

        // 트리 구조 표현을 위한 그래프 구현
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        boolean[] visited = new boolean[n]; // 방문 여부 확인용 배열
        int[] parentNode = new int[n];      // 부모 노드 저장 배열

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : tree.get(v))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parentNode[node] = v; // 부모 노드 찾은 후 저장
                }
        }

        // 루트 노드를 제외한 나머지 노드의 부모 노드 출력
        for (int i = 1; i < n; i++)
            System.out.println(parentNode[i] + 1);
    }

}