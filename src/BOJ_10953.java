import java.io.*;
import java.util.StringTokenizer;

// A+B - 6
public class BOJ_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        // 테스트 케이스의 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        // A + B 입력
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}