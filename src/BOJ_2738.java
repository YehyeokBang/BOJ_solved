import java.io.*;
import java.util.StringTokenizer;

// 행렬 덧셈
public class BOJ_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 행렬 A
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 B
        int[][] B = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 덧셈 결과 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(String.valueOf(A[i][j] + B[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}