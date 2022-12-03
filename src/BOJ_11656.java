import java.io.*;
import java.util.*;

// 접미사 배열
public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 입력, 입력받은 문자열의 크기로 배열 생성
        String s = br.readLine();
        String[] strArray = new String[s.length()];

        // 하나씩 잘라서 넣음
        for (int i = 0; i < s.length(); i++) {
            strArray[i] = s.substring(i, s.length());
        }

        // 사전 순으로 정렬
        Arrays.sort(strArray);

        // 출력
        for (String str : strArray) {
            bw.write(str);
            bw.write('\n');
        }
        bw.close();
    }
}