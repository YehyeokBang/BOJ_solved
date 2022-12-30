import java.io.*;

// 별 찍기 - 8
public class BOJ_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 위 + 중간
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }

            for(int j = 0; j < N - i; j++) {
                sb.append(" ");
            }

            for(int j = 0; j < N - i; j++) {
                sb.append(" ");
            }

            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 아래
        for(int i = N - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }

            for(int j = 0; j < N - i; j++) {
                sb.append(" ");
            }

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