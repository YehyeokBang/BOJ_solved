import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌 게임 3
public class BOJ_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돌 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 결과 출력
        System.out.println((n % 7 == 0 || n % 7 == 2) ? "CY" : "SK");
    }
}