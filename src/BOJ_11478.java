import java.io.*;
import java.util.HashMap;

// 서로 다른 부분 문자열의 개수
public class BOJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 입력
        String s = br.readLine();

        // 해시맵 선언
        HashMap<String,String> map = new HashMap<>();

        // 부분 문자열 해시맵에 추가
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                // 해시맵은 중복키 자동 제거
                map.put(s.substring(i, j + 1), "");
            }
        }

        // 출력
        bw.write(String.valueOf(map.size()));
        bw.close();
    }
}