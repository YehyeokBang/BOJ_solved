import java.io.*;

// 문자열
public class BOJ_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        // T만큼 테스트
        for (int tc = 0; tc < T; tc++) {
            // 문자열 입력받고 split
            String[] input = br.readLine().split("");

            // 입력받은 문자열의 첫 글자와 마지막 글자 출력
            bw.write(input[0]);
            bw.write(input[input.length - 1]);
            bw.write("\n");
        }
        bw.close();
    }
}