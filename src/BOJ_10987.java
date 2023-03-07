import java.io.*;

// 모음의 개수
public class BOJ_10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 입력
        String word = br.readLine();

        // 모음 수 저장 변수 선언
        int count = 0;

        // 모음 판별
        for(int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                case 'o':
                case 'e':
                case 'i':
                case 'u':
                    count++;
                    break;
            }
        }

        // 출력
        System.out.print(count);
    }
}