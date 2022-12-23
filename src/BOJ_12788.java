import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 제 2회 IUPC는 잘 개최될 수 있을까?
public class BOJ_12788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // CTP 회원의 수 N
        int N = Integer.parseInt(br.readLine());

        // 참가한 팀의 수 M, 팀을 구성하는 팀원의 수 K
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 회원들이 가지고 있는 펜의 수
        Integer[] pen = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pen[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬
        Arrays.sort(pen, Collections.reverseOrder());

        int need = M * K; // 필요한 펜의 수
        int member = 0; // 빌린 회원의 수
        for(int i = 0; i < N; i++) {
            need -= pen[i];
            member++;

            // 충분한 양의 펜을 빌린 경우
            if(need <= 0) {
                break;
            }

            // 모든 회원에게 빌려도 부족한 경우
            if(i == N - 1 && need > 0) {
                bw.write("STRESS");
                bw.close();
                return;
            }
        }

        // 최소한의 회원들에게 빌렸을 경우 빌린 회원의 수 출력
        bw.write(String.valueOf(member));
        bw.close();
    }
}