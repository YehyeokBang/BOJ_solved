import java.io.*;
import java.util.StringTokenizer;

// 행복
public class BOJ_15969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수 입력
        int N = Integer.parseInt(br.readLine());

        // 학생들의 점수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최소, 최고 점수 저장할 변수 선언 및 초기화
        int min = 1001;
        int max = -1;

        // 반복문을 통해 점수 하나씩 가져와서
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 최소, 최대 점수를 찾아냄
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        // 최소, 최대 점수의 차를 출력
        System.out.print(max - min);
    }
}