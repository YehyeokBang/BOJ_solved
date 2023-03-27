import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());

        // T만큼 테스트
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0; // 짝수의 합계를 저장하는 변수
            int min = 101; // 최솟값을 저장하는 변수

            // 7개 정수 입력
            for (int i = 0; i < 7; i++) {
                int num = Integer.parseInt(st.nextToken());

                // 짝수일 경우
                if(num % 2 == 0) {
                    // 최솟값을 비교해보고
                    if (num < min) {
                        min = num;
                    }
                    // 짝수 합계에 더한다
                    sum += num;
                }
            }

            // 출력
            bw.write(String.valueOf(sum));
            bw.write(" ");
            bw.write(String.valueOf(min));
            bw.write("\n");
        }
        bw.close();
    }
}