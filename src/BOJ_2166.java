import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다각형의 면적
public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 점의 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 점의 좌표 입력
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }

        // 신발끈 공식을 사용, 다각형 면적 구하기
        double temp1 = 0.0;
        double temp2 = 0.0;
        for (int i = 0; i < n; i++) {
            int index = i == n - 1 ? 0 : i + 1;
            temp1 += arr[i][0] * arr[index][1];
            temp2 += arr[i][1] * arr[index][0];
        }

        // 출력
        System.out.printf("%.1f", Math.abs(temp1 - temp2) / 2.0);
    }
}