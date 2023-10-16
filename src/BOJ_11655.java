import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ROT13
public class BOJ_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += 13;
                if (c > 'z') c -= 26;
            } else if (c >= 'A' && c <= 'Z') {
                c += 13;
                if (c > 'Z') c -= 26;
            }
            System.out.print(c);
        }
    }
}