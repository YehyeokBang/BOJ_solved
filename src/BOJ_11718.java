import java.io.*;

// 그대로 출력하기
public class BOJ_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받고 바로 출력
        String s = "";
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}