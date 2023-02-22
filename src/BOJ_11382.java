import java.io.*;
import java.util.StringTokenizer;

// 꼬마 정민
public class BOJ_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B, C 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());

        // 출력
        System.out.println(A + B + C);
    }
}