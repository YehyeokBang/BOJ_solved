import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
    static int[] nums;
    static int[] arr;
    static boolean[] isVisited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        nums = new int[N];
        arr = new int[N];
        isVisited = new boolean[N];

        // N개의 숫자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 입력받은 숫자 정렬
        Arrays.sort(nums);

        // 탐색
        dfs(0);

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    private static void dfs (int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[count] = nums[i];
                dfs(count + 1);
                isVisited[i] = false;
            }
        }
    }
}