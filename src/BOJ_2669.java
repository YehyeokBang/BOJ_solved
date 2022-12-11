import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네 개의 합집합의 면적 구하기
public class BOJ_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 좌표 평면
        boolean[][] map = new boolean[101][101];

        // 입력
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    map[j][k] = true;
                }
            }
        }

        // 면적 확인
        int count = 0;
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(map[i][j] == true) {
                    count++;
                }
            }
        }

        // 출력
        System.out.print(count);
    }
}
