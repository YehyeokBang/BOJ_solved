import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 명령 프롬프트
public class BOJ_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt((br.readLine()));

        String[] arr = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr[0].length(); i++) {
            boolean flag = true;
            for (int j = 1; j < testCase; j++) {
                if (arr[0].charAt(i) != arr[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(arr[0].charAt(i));
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}