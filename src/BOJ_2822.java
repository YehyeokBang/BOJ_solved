import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// 점수 계산
public class BOJ_2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("\n");

        // 각 문제의 점수와 문제 번호 저장
        int[][] num = new int[8][2];

        // 각 문제의 점수와 문제 번호 입력
        int index = 1;
        for(int i = 0; i < 8; i++) {
            num[i][0] = Integer.parseInt(br.readLine());
            num[i][1] = index++;
        }

        // 각 문제의 배점을 기준으로 내림차순 정렬
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        // 가장 높은 점수 5개의 합과 문제 번호 알아내기
        int sum = 0;
        int[] temp = new int[5];
        for(int i = 0; i < 5; i++) {
            sum += num[i][0];
            temp[i] = num[i][1];
        }
        Arrays.sort(temp);
        for(int i = 0; i < 5; i++) {
            sb.append(temp[i]).append(" ");
        }

        // 출력
        bw.write(String.valueOf(sum));
        bw.write(String.valueOf(sb));
        bw.close();
    }
}