import java.io.*;

// 알파벳 개수
public class BOJ_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어 s 입력
        String s = br.readLine();

        // 문자별 개수 저장
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97] += 1;
        }

        // 출력
        for(int i = 0; i < 26; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.write(" ");
        }
        bw.close();
    }
}