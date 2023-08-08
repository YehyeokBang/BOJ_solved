import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 2
public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 수열 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, sum = 0, cnt = 0;
        while(true) {
            if(sum >= m) {
                sum -= arr[s++];
            } else if (e == n) {
                break;
            } else {
                sum += arr[e++];
            }
            if(sum==m) {
                cnt++;
            }
        }

        // 출력
        System.out.println(cnt);
    }
}