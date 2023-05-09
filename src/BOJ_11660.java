import java.io.*;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 표의 크기 n, 테스트 케이스의 개수 m 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 표의 행마다 누적합을 저장할 배열
        // {1, 2, 3 ,4} 행이라면 {1, 3, 6, 10}으로 저장
        int[][] table = new int[n][n];

        // table 값 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp += Integer.parseInt(st.nextToken());
                table[i][j] = temp;
            }
        }

        // 주어진 구간의 합 구하기
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = x1 - 1; j < x2; j++) {
                if (y1 <= 1) sum += table[j][y2 - 1];
                else sum += (table[j][y2 - 1] - table[j][y1 - 2]);
            }
            sb.append(sum).append('\n');
        }

        // 출력
        System.out.println(sb);
    }
}