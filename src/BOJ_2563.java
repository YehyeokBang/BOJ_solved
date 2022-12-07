import java.io.*;
import java.util.StringTokenizer;

// 색종이
public class BOJ_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 색종이의 수 입력
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[101][101];

        // 정사각형 입력
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x + 10; i++) {
                for(int j = y; j < y + 10; j++) {
                    paper[i][j] = 1;
                }
            }
        }

        // 넓이 출력
        int count = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == 1) {
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
