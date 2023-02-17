import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카드 게임
public class BOJ_5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 5게임의 득점을 나타내는 정수 입력
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        // 출력
        System.out.print(sum);
    }
}