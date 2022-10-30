import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

// 적록색약
public class BOJ_10026 {
    static int N; // N × N
    static String[][] picture;
    static boolean[][] checked;
    static int area = 0; // 구역
    static String before = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // N 입력받기
        N = Integer.parseInt(br.readLine());
        picture = new String[N][N];
        checked = new boolean[N][N];

        // 그림 입력받기
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                picture[i][j] = String.valueOf(line.charAt(j));
            }
        }
        before = picture[0][0]; // 처음 시작점, 이전 색상값

        // 탐색하며 구역의 개수 알아내기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(checked[i][j] == false) {
                    before = picture[i][j];
                    RGB(i, j);
                    area++;
                }
            }
        }
        sb.append(area).append(" ");

        // 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다
        // 초록색을 빨간색이라고 가정
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(picture[i][j].equals("G")) {
                    picture[i][j] = "R";
                }
            }
        }

        // 탐색에 필요한 변수들 모두 리셋
        before = picture[0][0];
        checked = new boolean[N][N];
        area = 0;
        // 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(checked[i][j] == false) {
                    before = picture[i][j];
                    RGB(i, j);
                    area++;
                }
            }
        }
        sb.append(area);

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 깊이 우선 탐색
    public static void RGB(int row, int col) {
        if(row < 0 || row > N - 1 || col < 0 || col > N) {
            return;
        }
        if(!before.equals(picture[row][col])) {
            return;
        }
        before = picture[row][col];
        checked[row][col] = true;

        // 시작점에서 네 방향으로 모두 탐색, index 안벗어나게 조건문
        if(col > 0) {
            if(!checked[row][col - 1]) {
                RGB(row, col - 1);
            }
        }
        if(col < N - 1) {
            if(!checked[row][col + 1]) {
                RGB(row, col + 1);
            }
        }
        if(row > 0) {
            if(!checked[row - 1][col]) {
                RGB(row - 1, col);
            }
        }
        if(row < N - 1) {
            if(!checked[row + 1][col] && row < N - 1) {
                RGB(row + 1, col);
            }
        }
    }
}