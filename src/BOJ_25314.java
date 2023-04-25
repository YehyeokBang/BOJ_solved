import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 코딩은 체육과목 입니다
public class BOJ_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = n / 4; i > 0; i--) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}