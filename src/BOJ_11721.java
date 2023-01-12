import java.io.*;

// 열 개씩 끊어 출력하기
public class BOJ_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");

        // 문자열 입력
        String s = br.readLine();

        // 10개 끊을 때 사용할 변수
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            count++;

            // 10개씩 쓰고 끊기
            if(count == 10) {
                sb.append("\n");
                count = 0;
            }
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}