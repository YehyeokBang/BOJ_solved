import java.io.*;

// 별 찍기 - 6
public class BOJ_2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // N 입력
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            // 왼쪽 공백
            for(int j = 0; j < i; j++) {
                sb.append(" ");
            }
            // 가운데 별
            for(int star = N * 2 - 1 - (2 * i); star >= 1; star--) {
                sb.append("*");
            }
            // 줄 변경
            if(i != N - 1) {
                sb.append("\n");
            }
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}