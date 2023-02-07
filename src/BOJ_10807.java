import java.io.*;
import java.util.StringTokenizer;

// 개수 세기
public class BOJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // -100 ~ 100 배열 (0 ~ 200), 201칸
        int[] num = new int[201];

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 숫자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[Integer.parseInt(st.nextToken()) + 100] += 1;
        }

        // 위 입력한 N개의 숫자 중에서 몇 개인지 알고싶은 수 v 입력
        int v = Integer.parseInt(br.readLine());

        // 출력
        bw.write(String.valueOf(num[v + 100]));
        bw.close();
    }
}