import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플러그
public class BOJ_2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int multiTap = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < multiTap; i++) {
            int plug = Integer.parseInt(br.readLine());
            result += plug;
        }

        // 출력
        System.out.println(result - (multiTap - 1));
    }
}