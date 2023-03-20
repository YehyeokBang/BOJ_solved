import java.io.*;
import java.util.Arrays;

public class BOJ_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받는 정수를 저장할 배열 선언 및 초기화
        int[] arr = new int[5];

        // 평균 구할 때 쓸 합계를 저장할 변수
        int sum = 0;
        // 5개의 정수 한 줄씩 입력받기
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 평균값 구하기
        bw.write(String.valueOf(sum / 5));
        bw.write("\n");

        // 오름차순 정렬
        Arrays.sort(arr);

        // 중앙값 구하기
        bw.write(String.valueOf(arr[2]));
        bw.close();
    }
}