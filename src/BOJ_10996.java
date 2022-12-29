import java.io.*;

// 별 찍기 - 21
public class BOJ_10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // level -> 한 줄
        for(int level = 0; level < N * 2; level++) {
            // 0, 2, 4, ...번째 줄 (n % 2 == 0)
            if(level % 2 == 0) {
                for(int i = 0; i < N / 2 + N % 2; i++) {
                    sb.append("* ");
                }
            }
            // 1, 3, 5, ...번째 줄 (n % 2 == 1)
            if(level % 2 == 1) {
                for(int i = 0; i < N / 2; i++) {
                    sb.append(" *");
                }
            }
            sb.append("\n");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}