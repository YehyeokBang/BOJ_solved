import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문서 검색
public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int docLen = doc.length();
        int wordLen = word.length();

        int cnt = 0;
        for(int i = 0; i<docLen-wordLen + 1; i++) {
            if(doc.substring(i, i + wordLen).equals(word)) {
                cnt++;
                i += wordLen-1;
            }
        }

        System.out.println(cnt);
    }
}
