import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 수열
public class BOJ_10974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 8, N 입력
        int N = Integer.parseInt(br.readLine());

        // 백트래킹
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        dfs(N, arr, visited, 0);
    }

    // dfs, 백트래킹
    public static void dfs(int N, int[] arr, boolean[] visited, int depth) {
        // depth가 N이면 모든 수열을 다 만든 것이므로 출력
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // depth가 N보다 작으면 아직 수열을 다 만들지 않은 것이므로
        // 아직 방문하지 않은 수를 찾아서 수열에 넣고 dfs 호출
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, arr, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}