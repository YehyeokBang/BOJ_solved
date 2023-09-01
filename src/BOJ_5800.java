import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 성적 통계
public class BOJ_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 반의 수 입력
        int classCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < classCount; i++) {
            // 학생 수, 성적 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentCount = Integer.parseInt(st.nextToken());
            int[] score = new int[studentCount];
            for (int j = 0; j < studentCount; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            score = Arrays.stream(score).sorted().toArray();

            // 성적 최댓값, 최솟값 계산
            int max = score[studentCount - 1];
            int min = score[0];

            // 성적 차이 계산
            int gap = 0;
            for (int j = 1; j < studentCount; j++) {
                gap = Math.max(gap, score[j] - score[j - 1]);
            }

            sb.append("Class ").append(i + 1);
            sb.append("\nMax ").append(max).append(", Min ").append(min).append(", Largest gap ").append(gap).append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}