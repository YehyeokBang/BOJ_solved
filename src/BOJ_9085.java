import java.io.*;
import java.util.StringTokenizer;

// 더하기
public class BOJ_9085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        // T만큼 테스트 반복
        for(int tc = 0; tc < T; tc++) {
            // 입력할 자연수의 개수 N 입력
            int N = Integer.parseInt(br.readLine());

            // 합을 저장할 변수 선인 및 초기화
            int result = 0;

            // N개의 자연수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                result += Integer.parseInt(st.nextToken());
            }
            bw.write(String.valueOf(result));
            bw.write("\n");
        }
        // 출력
        bw.close();
    }
}