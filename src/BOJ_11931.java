import java.io.*;
import java.util.Arrays;
import java.util.Collections;

// 수 정렬하기 4
public class BOJ_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 개수 N개 입력
        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];

        // N개의 수 입력
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        Arrays.sort(nums, Collections.reverseOrder());

        // 출력
        for(int i = 0; i < N; i++) {
            bw.write(String.valueOf(nums[i]));
            bw.write("\n");
        }
        bw.close();
    }
}