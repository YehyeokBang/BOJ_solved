import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 3
public class BOJ_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 별 찍기
        for(int i = N; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append('\n');
        }

        // 출력
        System.out.print(sb);
    }
}