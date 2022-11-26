import java.io.*;
import java.util.StringTokenizer;

// N과 M (2)
public class BOJ_15650 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // 탐색
        dfs(1, 0);

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // at: 현재 위치, depth, 현재 깊이
    public static void dfs(int at, int depth) {
        // 길이가 M이랑 같을 경우
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 현재 부터 탐색하도록
        for (int i = at; i <= N; i++) {
            // 현재 깊이를 인덱스로 사용, i를 저장
            arr[depth] = i;

            // 재귀
            dfs(i + 1, depth + 1);
        }
    }
}