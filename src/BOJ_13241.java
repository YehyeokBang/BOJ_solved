import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소공배수
public class BOJ_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 최대공약수 구하기
        long gcd = gcd(Math.max(a, b), Math.min(a, b));

        // a와 b의 최소공배수 출력
        // (a * b) / 최대공약수
        System.out.print((a * b) / gcd);
    }

    public static long gcd(long a, long b){
        while (b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}