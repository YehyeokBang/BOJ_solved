import java.io.*;

// 별 찍기 - 23
public class BOJ_13015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // N 입력
        int i, j; // 반복문에 쓸 변수

        for (i = 1; i <= 2 * N - 1; i++) {
            if (i == 1 || i == (N + (N - 1))) { // 맨 위, 맨 아래
                for (j = 1; j <= N; j++) {
                    bw.write("*");
                }
                for (j = 1; j <= (N - 1) + (N - 2); j++) { // 테두리 바깥 공백
                    bw.write(" ");
                }
                for (j = 1; j <= N; j++) {
                    bw.write("*");
                }
            }
            else { // 그 외, 기둥을 만드는 부분
                if (i < N) {
                    for (j = 1; j <= i - 1; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= (N - 1) + (N - 2) - 2 * (i - 1); j++) { // 테두리 바깥 공백
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                }
                if (i > N) {
                    for (j = 1; j <= N - (i % N) - 1; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= 2 * (i % N) - 1; j++) { // 테두리 바깥 공백
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                }
                else if (i == N) {
                    for (j = 1; j <= i - 1; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                    for (j = 1; j <= N - 2; j++) {
                        bw.write(" ");
                    }
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}