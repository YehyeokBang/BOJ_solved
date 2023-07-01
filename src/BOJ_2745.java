import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진법 변환
public class BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n: 진법 변환할 수, b: 진법
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        // 진법 변환
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c >= 'A') {
                result = result * b + (c - 'A' + 10);
            } else {
                result = result * b + (c - '0');
            }
        }

        // 출력
        System.out.println(result);
    }
}