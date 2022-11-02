import java.io.*;
import java.util.StringTokenizer;

// GCD 합
public class BOJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine()); // 테스트 수

        // 테스트 수만큼 반목
        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 첫 자리 입력받은 수는 후에 입력받을 수의 개수
            int n = Integer.parseInt(st.nextToken());
            int[] num = new int[n];

            // 첫 자리에 입력받은 수만큼 수를 입력받기
            for(int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            // GCD()를 이용해 만들 수 있는 짝들의 최대공약수를 구하고 모두 더함
            long sum = 0; // int를 쓰면 테스트 중 범위를 벗어날 수 있음
            for(int j = 0; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    int a = num[j] >= num[k] ? num[j] : num[k];
                    int b = num[j] >= num[k] ? num[k] : num[j];
                    sum += GCD(a, b);
                }
            }
            sb.append(sum);
            if(i < testCase - 1) {
                sb.append('\n');
            }
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // GCD 최대공약수 구하는 메소드
    static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return GCD(b, a % b);
        }
    }
}
