import java.io.*;
import java.util.StringTokenizer;

// 시험 점수
public class BOJ_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 민국이의 점수 입력 및 합산
        st = new StringTokenizer(br.readLine());
        int S = 0;
        while (st.hasMoreTokens()) {
            S += Integer.parseInt(st.nextToken());
        }

        // 만세의 점수 입력 및 합산
        st = new StringTokenizer(br.readLine());
        int T = 0;
        while (st.hasMoreTokens()) {
            T += Integer.parseInt(st.nextToken());
        }

        // 출력
        System.out.print(Math.max(S, T));
    }
}