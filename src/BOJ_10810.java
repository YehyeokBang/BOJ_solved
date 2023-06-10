import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 공 넣기
public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 생성
        int[] arr = new int[n + 1];

        // m번 반복
        for (int a = 0; a < m; a++) {
            // i, j, k 입력
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // i번째부터 j번째까지 k로 채우기
            for (int b = i; b <= j; b++) {
                arr[b] = k;
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}