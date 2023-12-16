import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 거스름돈
public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                ans += n / 5;
                n = 0;
            } else {
                n -= 2;
                ans++;
            }
        }

        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
