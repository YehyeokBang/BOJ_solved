import java.io.*;
import java.util.Arrays;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 수의 개수, 수를 저장할 배열
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] count = new int[8001];

        // 출력할 값을 저장할 변수
        int mean;   // 산술평균
        int median; // 중앙값
        int mode = 0;   // 최빈값
        int range;  // 범위

        int min = 4001;
        int max = -4001;
        int sum = 0;
        int maxCount = 0; // 최대 중복 수

        // 수 입력받기
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());

            // 수들의 합 구하기
            sum += array[i];
            // 최솟값 구하기
            if(min > array[i]) {
                min = array[i];
            }
            // 최댓값 구하기
            if(max < array[i]) {
                max = array[i];
            }
            // 최빈값 구하기
            count[4000 + array[i]] += 1;
            if(maxCount < count[4000 + array[i]]) {
                maxCount = count[4000 + array[i]];
            }
        }

        // 산술평균, 범위 (수가 1개라면 범위는 0)
        mean = (int)Math.round((double)sum / (double)N);
        range = Math.abs(max - min);
        if(N == 1) range = 0;

        // 정렬 후 중앙값
        Arrays.sort(array);
        median = array[N / 2];

        // 최빈값을 구함 + 두 개 이상이면, 두 번째로 작은 값
        boolean second_check = false;
        for(int i = 0; i <= 8000; i++) {
            if(count[i] == maxCount) {
                mode = i - 4000;
                if(second_check == true) {
                    // 두 번째로 작은 값을 찾으면 maxCount를 못쓰게 만듬
                    maxCount = -1;
                }
                second_check = true;
            }
        }

        // 출력
        sb.append(mean).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
