import java.io.*;

// 팰린드롬인지 확인하기
public class BOJ_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 입력
        String word = br.readLine();

        // StringBuilder의 reverse()를 이용해서 팰린드롬인지 확인 후 결과 출력
        StringBuilder sb = new StringBuilder(word);
        System.out.print(word.equals(sb.reverse().toString()) ? "1" : "0");
    }
}