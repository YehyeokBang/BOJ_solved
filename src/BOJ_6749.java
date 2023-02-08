import java.io.*;

// Next in line
public class BOJ_6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1, 2번 째 입력
        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());

        // 출력
        bw.write(String.valueOf(two + two - one));
        bw.close();
    }
}