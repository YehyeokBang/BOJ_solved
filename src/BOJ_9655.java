import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌게임
public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돌의 개수 n 입력
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) System.out.print("SK");
        else System.out.print("CY");
    }
}