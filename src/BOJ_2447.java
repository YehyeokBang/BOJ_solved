import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

// 별 찍기 - 10
public class BOJ_2447 {
    public static boolean[][] sky;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sky = new boolean[n][n];

        star(0, 0, n);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(sky[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append('\n');
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 별 찍어주는 메소드
    public static void star(int row, int col, int n) {
        // 사이즈 분할하다가 3이되면
        /*  ***
         * * 형태로 만듬 true: *, false: 공백
         ***
         */
        if(n == 3) {
            for(int i=row; i<row+3; i++) {
                for(int j=col; j<col+3; j++) {
                    sky[i][j] = true;
                }
            }
            sky[row+1][col+1] = false;
            return;
        }
        /*  ***
         * * 형태로 분할해서 재귀
         ***
         */
        star(row, col, n / 3);                             // 1 자리
        star(row, col + n / 3, n / 3);                     // 2 자리
        star(row, col + (n / 3) * 2, n / 3);               // 3 자리
        star(row + n / 3, col, n / 3);                     // 4 자리
        // 5자리는 빈 공백임
        star(row + n / 3, col + (n / 3) * 2, n / 3);       // 6 자리
        star(row + (n / 3) * 2, col, n / 3);               // 7 자리
        star(row + (n / 3) * 2, col + n / 3, n / 3);       // 8 자리
        star(row + (n / 3) * 2, col + (n / 3) * 2, n / 3); // 9 자리
    }
}