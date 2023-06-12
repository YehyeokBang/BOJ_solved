import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바구니 뒤집기
public class BOJ_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 바구니의 개수 N, 바구니의 크기 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 바구니 배열
        int[] basket = new int[N + 1];

        // 바구니 배열 초기화
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        // 바구니 뒤집기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // 바구니 뒤집기 시작점 I, 끝점 J
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            // 바구니 뒤집기
            for (int j = 0; j < (J - I + 1) / 2; j++) {
                int temp = basket[I + j];
                basket[I + j] = basket[J - j];
                basket[J - j] = temp;
            }
        }

        // 바구니 배열 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}