import java.io.*;
import java.util.StringTokenizer;

// 상근이의 친구들
public class BOJ_5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 0 0 <- 입력 될 때까지 반복
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            // m, f 입력
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            // 0 0 입력한 경우 종료
            if(m == 0 && f == 0) {
                break;
            }

            // 친구의 수
            bw.write(String.valueOf(m + f));
            bw.write("\n");
        }
        bw.close();
    }
}