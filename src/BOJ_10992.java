import java.io.*;

// 별 찍기 - 17
public class BOJ_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 위에서부터 N - 1줄 별 찍기
        for(int row = 1; row < N; row++) {
            // 좌측 공백
            for(int space = 0; space < N - row; space++) {
                bw.write(" ");
            }
            // 맨 꼭대기 줄 별 찍기
            if(row == 1) {
                bw.write("*\n");
            }
            // 나머지 줄 별 찍기
            else {
                bw.write("*");
                // 사이 공백
                for(int space = 0; space < (row - 1) * 2 - 1; space++) {
                    bw.write(" ");
                }
                bw.write("*\n");
            }
        }

        // 마지막 N번째 줄 N * 2 - 1개의 별 찍기
        for(int star = 0; star < N * 2 - 1; star++) {
            bw.write("*");
        }

        bw.close();
    }
}