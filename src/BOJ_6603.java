import java.io.*;
import java.util.StringTokenizer;

// 로또
public class BOJ_6603 {
    static StringBuilder sb = new StringBuilder("");
    static int k; // 각 케이스마다 입력할 수의 개수 (=집합 S의 요소 개수)
    static int[] S; // 집합 S, 입력 받은 k개의 숫자
    static int[] arr; // 집합 S에서 로또 번호를 뽑고 저장해둘 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            // 입력
            st = new StringTokenizer(br.readLine());

            // 한 줄의 첫 번째 수는 k, 다음 k개의 수는 집합 S에 포함되는 수
            k = Integer.parseInt(st.nextToken());
            if(k == 0) { // 만약 0이라면 입력 종료
                break;
            }

            // 집합 S에 저장
            S = new int[k];
            for(int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            // 집합 S에서 6개를 뽑아 저장해둘 배열
            arr = new int[6];
            // 탐색
            lotto(0, 0);
            sb.append('\n');
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void lotto(int now, int depth) {
        // 6개 다 뽑았으면 sb에 저장
        if(depth == 6) {
            for(int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // now 부터 탐색
        for(int i = now; i < k; i++) {
            arr[depth] = S[i];

            // 재귀
            lotto(i + 1, depth + 1);
        }
    }
}