import java.io.*;

// 별 찍기 - 4
public class BOJ_2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        for(int i = N; i > 0; i--) {
            for(int j = 0; j < N - i; j++) {
                sb.append(" ");
            }
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}