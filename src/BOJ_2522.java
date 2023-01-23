import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 12
public class BOJ_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 위
        for(int i = 1; i <= N; i++) {
            sb.append(" ".repeat(Math.max(0, N - i)));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        // 아래
        for(int i = N - 1; i > 0; i--) {
            sb.append(" ".repeat(Math.max(0, N - i)));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        // 출력
        System.out.print(sb);
    }
}