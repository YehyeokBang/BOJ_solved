import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 커트라인
public class BOJ_25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 응시자 수, 합격자 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 점수 입력
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(score);

        // 커트라인 출력
        System.out.println(score[n - k]);
    }
}