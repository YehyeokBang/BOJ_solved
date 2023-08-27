import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진법 변환 2
public class BOJ_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, b 입력
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 10진수인 n을 b진수로 변환하여 출력
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % b;
            n /= b;
            if (r < 10) {
                sb.append(r);
            } else {
                sb.append((char) (r + 55));
            }
        }

        // 역순으로 출력
        System.out.println(sb.reverse());
    }
}