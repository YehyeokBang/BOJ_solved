import java.io.*;
import java.util.StringTokenizer;

// 공 바꾸기
public class BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니의 개수
        int M = Integer.parseInt(st.nextToken()); // 공의 개수
        int[] basket = new int[N + 1]; // 바구니

        // 바구니에 공 넣기
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        // 공의 위치 바꾸기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 교환
            int temp = basket[x];
            basket[x] = basket[y];
            basket[y] = temp;
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}