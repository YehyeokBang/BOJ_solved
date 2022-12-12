import java.io.*;
import java.util.StringTokenizer;

// 단어 뒤집기
public class BOJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수
        int N = Integer.parseInt(br.readLine());

        // 테스트 케이스 수 만큼 반복
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 한 문장 단어별로 뒤집기
            while(st.hasMoreTokens()) {
                StringBuffer sbf = new StringBuffer(st.nextToken());
                String reverse = sbf.reverse().toString();
                sb.append(reverse).append(" ");
            }
            sb.append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
