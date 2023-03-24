import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대소문자 바꾸기
public class BOJ_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String s = br.readLine();

        // 문자 하나씩 살펴보기
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 대문자일 경우 소문자로 바꿔서 출력
            if (Character.isUpperCase(c)) {
                System.out.print(String.valueOf(c).toLowerCase());
            } else { // 소문자일 경우 대문자로 바꿔서 출력
                System.out.print(String.valueOf(c).toUpperCase());
            }
        }
    }
}