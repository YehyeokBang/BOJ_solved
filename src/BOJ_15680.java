import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연세대학교
public class BOJ_15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(N == 0 ? "YONSEI" : "Leading the Way to the Future");
    }
}