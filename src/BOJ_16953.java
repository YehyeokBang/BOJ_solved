import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A -> B
public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B 입력
        StringTokenizer st = new StringTokenizer((br.readLine()));
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 결과 출력
        System.out.println(solution(A, B));
    }

    public static int solution(int A, int B) {
        int answer = 0;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            answer++;
        }

        return B == A ? answer + 1 : -1;
    }
}