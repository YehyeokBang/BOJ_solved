import java.io.*;

// 별 찍기 - 16
public class BOJ_10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 별 찍기
        for(int row = 1; row <= N; row++) {
            for(int star = 1; star <= row; star++) {
                if(star == 1) {
                    sb.append(" ".repeat(N - row));
                    sb.append("*");
                }
                else {
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