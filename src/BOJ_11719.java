import java.io.*;

// 그대로 출력하기 2
public class BOJ_11719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받고 바로 출력
        String s = "";
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}