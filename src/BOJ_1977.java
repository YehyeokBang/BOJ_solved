import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // m, n 입력
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;  // 최소 완전제곱수
        int sum = 0;  // 완전제곱수들의 합
        for (int i = 1; i * i <= n; i++) {
            if (i * i >= m && i * i <= n) {  // i의 제곱수가 범위 안에 있을 때
                min = Math.min(i * i, min);
                sum += i * i;
            }
        }
        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}