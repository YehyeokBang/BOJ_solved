import java.io.*;
import java.util.StringTokenizer;

// 점수계산
public class BOJ_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        // N개의 수 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 채점
        int result = 0;
        int temp = 0;
        for(int n : nums) {
            if(n == 1) {
                temp++;
                result += temp;
            }
            else {
                temp = 0;
            }
        }

        // 출력
        bw.write(String.valueOf(result));
        bw.close();
    }
}