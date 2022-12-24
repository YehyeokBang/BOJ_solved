import java.io.*;

// 16진수
public class BOJ_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 16진수 입력
        String hexadecimal = br.readLine();

        // 10진수로 변환
        int decimal = Integer.parseInt(hexadecimal, 16);

        // 출력
        bw.write(String.valueOf(decimal));
        bw.close();
    }
}
