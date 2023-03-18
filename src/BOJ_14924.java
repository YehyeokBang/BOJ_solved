import java.io.*;
import java.util.StringTokenizer;

// 폰 노이만과 파리
public class BOJ_14924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S, T, D 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 출력
        System.out.print(D / (2 * S) * T);
    }
}