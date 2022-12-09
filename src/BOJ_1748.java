import java.io.*;

// 수 이어 쓰기 1
public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        int count = 0; // 자릿수
        int plus = 1;  // 자릿수에 더하는 값
        int num = 10;  // 몇 자릿수 더할지 판단
        for(int i=1; i<=N; i++) {
            // 자릿수가 늘어날 때마다
            if(i%num == 0) {
                plus ++;
                num *= 10;
            }
            count += plus;
        }

        // 출력
        bw.write(String.valueOf(count));
        bw.close();
    }
}