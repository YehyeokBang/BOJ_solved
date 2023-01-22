import java.io.*;
import java.util.StringTokenizer;

// 행렬 곱셈
public class BOJ_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        // 행렬 A의 크기 입력
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 행렬 A 입력
        int[][] A = inputMatrix(br, st, N, M);

        // 행렬 B의 크기 입력
        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        // 행렬 B 입력
        int[][] B = inputMatrix(br, st, X, Y);

        // 행렬 A, B 곱셈
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < Y; j++) {
                int n = 0;
                for(int k = 0; k < M; k++) {
                    n += A[i][k] * B[k][j];
                }
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 행렬 입력하는 메서드
    private static int[][] inputMatrix(BufferedReader br, StringTokenizer st, int n, int m) throws IOException {
        int[][] matrix = new int[n][m];

        st.hasMoreTokens();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }
}