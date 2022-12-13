import java.io.*;
import java.util.Arrays;
import java.util.Collections;

// 30
public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        String N = br.readLine();

        // 0이 포함되어 있지 않으면 30의 배수가 될 수 없음
        if(!N.contains("0")) {
            bw.write("-1");
        }
        else {
            int sum = 0;
            for(int i = 0; i < N.length(); i++) {
                sum += Integer.parseInt(String.valueOf(N.charAt(i)));
            }
            // 모든 자릿수의 합이 3의 배수면 30의 배수, 즉 최댓값을 출력하면 됨
            if(sum % 3 == 0) {
                String[] arr = N.split("");
                Arrays.sort(arr, Collections.reverseOrder());

                // 만들 수 있는 최댓값
                String result = "";
                for(int i = 0; i < N.length(); i++) {
                    result += arr[i];
                }
                bw.write(result);
            }
            // 아니면 30의 배수가 아님
            else {
                bw.write("-1");
            }
        }
        bw.close();
    }
}