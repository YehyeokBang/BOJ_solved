import java.io.*;

// 별 찍기 - 13
public class BOJ_2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 위
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        // 아래
        for(int i = N - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();
    }
}