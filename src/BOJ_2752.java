import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세수정렬
public class BOJ_2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 세 개를 저장할 배열 선언 및 초기화
        int[] nums = new int[3];

        // 숫자 세 개 입력 및 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(nums);

        // 출력
        System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
    }
}