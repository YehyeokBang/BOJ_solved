import java.io.*;
import java.util.StringTokenizer;

// 사파리월드
public class BOJ_2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 도메인의 유명도 N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        // |N - M| 출력
        System.out.print(Math.abs(N - M));
    }
}