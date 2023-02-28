import java.io.*;

// Hello Judge
public class BOJ_9316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 출력
        for(int i = 1; i <= N; i++) {
            System.out.println("Hello World, Judge " + i + "!");
        }
    }
}