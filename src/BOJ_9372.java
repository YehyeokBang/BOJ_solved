import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 상근이의 여행
public class BOJ_9372 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 반복
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 비행기 종류 입력
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            // 최소 비행기 종류 수는 N-1
            sb.append((N - 1)).append("\n");
        }
        System.out.println(sb);
    }
}