import java.io.*;

// 별 찍기 - 5
public class BOJ_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            // 왼쪽 공백
            for(int j = 0; j < N - i; j++) {
                sb.append(" ");
            }
            // 별 찍기
            for(int j = 0; j < i * 2 - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}