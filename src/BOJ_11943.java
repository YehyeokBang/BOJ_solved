import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 바구니의 과일 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 두 번째 바구니의 과일 개수 입력
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 결과 출력
        // 첫 번째 바구니에서 사과를 두 번재 바구니에서는 오렌지를 옮기는 방법 또는
        // 첫 번째 바구니에서 오렌지를 첫 번째 바구니에서는 사과를 옮기는 방법 중 최솟값
        System.out.print(Math.min(A + D, B + C));
    }
}