import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0 = not cute / 1 = cute
public class BOJ_10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt((br.readLine()));

        // 투표
        int vote = 0;
        for (int i = 0; i < n; i++) {
            vote = Integer.parseInt((br.readLine())) == 1 ? vote + 1 : vote - 1;
        }

        // 출력
        if (vote > 0) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}