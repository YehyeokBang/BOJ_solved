import java.io.*;
import java.util.StringTokenizer;

// 덩치
public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 전체 사람 수 입력 및 저장할 배열 초기화 [i][0] : 몸무게, [i][1] : 키
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 사람마다 모든 사람과 자신을 비교함 (브루트포스 방식)
        // rank(순위)를 1부터 시작, 해당 사람보다 덩치가 큰 사람이 있을 경우
        // 그 사람 순위는 뒤로 밀리기 때문에 rank 값 증가
        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                // 같은 사람은 비교 안하고 넘김
                if (i == j) {
                    continue;
                }
                // i번째 사람과 j번째 사람을 비교함
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }
        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}