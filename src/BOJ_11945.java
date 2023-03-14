import java.io.*;
import java.util.StringTokenizer;

// 뜨거운 붕어빵
public class BOJ_11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 두 개의 정수 입력, n = 행의 수, m = 열의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 붕어빵 모양 입력
        int[][] ground = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 좌우로 뒤집힌 모양 출력
        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j >= 0; j--) {
                bw.write(String.valueOf(ground[i][j]));
            }
            bw.write("\n");
        }
        bw.close();
    }
}