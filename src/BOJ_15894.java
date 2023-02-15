import java.io.*;

// 수학은 체육과목 입니다
public class BOJ_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 가장 아랫부분의 정사각형 개수 n 입력
        Long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(n * 4));
        bw.close();
    }
}