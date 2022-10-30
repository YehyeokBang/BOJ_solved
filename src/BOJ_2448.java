import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

// 별 찍기 - 11
public class BOJ_2448 {
    static boolean[][] star;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        star = new boolean[N][N * 2 - 1];

        theStar(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N * 2 - 1; j++) {
                if(star[i][j]) {
                    sb.append("*");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 큰 삼각형에서 3개의 필요한 구간만 구해서 그리는 방식 사이즈가 3이되면 삼각형을 그린다.
    static void theStar(int row, int col, int size) {
        if(size == 3) {
            star[row][col] = true;
            star[row + 1][col - 1] = true;
            star[row + 1][col + 1] = true;
            for(int i=col - 2; i<=col + 2; i++) {
                star[row + 2][i] = true;
            }
        }
        else {
            theStar(row, col, size / 2);
            theStar(row + size / 2, col - size / 2, size / 2);
            theStar(row + size / 2, col + size / 2, size / 2);
        }
    }
}