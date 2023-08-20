import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 수의 합
public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.parallelSort(arr);

        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n - 1;
        int sum = 0;

        while(start < end) {
            sum = arr[start] + arr[end];

            if(sum == x) count++;

            if(sum <= x) start++;
            else end--;
        }

        // 출력
        System.out.println(count);
    }
}
