import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 숫자 카드
public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 가지고 있는 숫자 카드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 가지고 있는 카드의 숫자 정보 입력
        st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st.hasMoreTokens();

        // 가지고 있는지 판별할 숫자 카드의 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 판별할 카드의 숫자 정보 입력
        st = new StringTokenizer(br.readLine(), " ");

        // 숫자 카드를 가지고 있는지 판별 후 출력
        for(int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
        bw.close();
    }
}