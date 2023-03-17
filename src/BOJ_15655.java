import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (6)
public class BOJ_15655 {
    static int N, M;
    static int[] input, array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M 입력 및 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];

        // N개의 수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(input);

        // 탐색에 사용할 배열과 방문 여부 저장 배열 초기화
        array = new int[M];
        visited = new boolean[N];

        // 탐색
        dfs(0, 0);

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    private static void dfs(int depth, int start) {
        // 깊이가 M과 같아지면 원소 append
        if (depth == M) {
            for (int value : array) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = input[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}