import java.io.*;
import java.util.StringTokenizer;

// Fly me to the Alpha Centauri
public class BOJ_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        // 테스트 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x; // x와 y의 차이(거리)

            /* 이동하는 최대 거리 dist = 4라면 -> 1 2 1 이동, 최댓값 2
               max 변하는 시점의 dist는 max의 제곱값
               dist = 9라면 -> 1 2 3 2 1, 최댓값 3
               따라서 max의 값은  dist의 루트 값에서 소수점을 버린 정수값 */
            int max = (int)Math.sqrt(dist);

            /* max를 구할 때 딱 떨어진다면(소수점까지) 위 예시와 같은 경우
               dist = 9, max = 3 -> 1 2 3 2 1, 총 5개 (3 * 2 - 1 = 5) */
            if(max == Math.sqrt(dist)) {
                sb.append(max * 2 - 1).append("\n");
            }
            /* 같은 max 값을 가지는 수를 나열해보면 count 값이 2번 변함
               한 번 변했을 경우의 count 값 구하기 */
            else if(dist <= max * max + max) {
                sb.append(max * 2).append("\n");
            }
            // 두 번 바뀐 마지막 구간
            else {
                sb.append(max * 2 + 1).append("\n");
            }
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}