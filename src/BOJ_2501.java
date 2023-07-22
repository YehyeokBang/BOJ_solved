import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수 구하기
public class BOJ_2501 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 약수를 구할 수, K: K번째로 작은 약수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 약수 구하기
        int cnt = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (cnt == k) {
                    answer = i;
                    break;
                }
            }
        }

        // 출력하기
        System.out.println(answer);
    }
}