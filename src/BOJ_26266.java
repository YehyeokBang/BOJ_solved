import java.io.*;

// 비즈네르 암호 해독
public class BOJ_26266 {
    static int n;
    static char[] key = new char[n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 평문, 암호문 입력
        String plainText = br.readLine();
        String cryptogram = br.readLine();
        n = plainText.length();

        // 해독
        key = new char[n];
        for(int i = 0; i < n; i++) {
            int temp = (cryptogram.charAt(i)) - (plainText.charAt(i));
            key[i] = (char)((temp < 1 ? temp + 26 : temp) + 64);
        }

        // 키 하나씩 대응해보기
        int minLen = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i != 0) {
                continue;
            }
            if(!check(i)) {
                continue;
            }
            minLen = i;
            break;
        }

        String k = "";

        for(int i = 0; i < minLen; i++) {
            k += key[i];
        }

        // 출력
        bw.write(k);
        bw.close();
    }

    public static boolean check(int m) {
        for(int i = m; i < n; i++) {
            if(key[i] != key[i % m]) {
                return false;
            }
        }
        return true;
    }
}