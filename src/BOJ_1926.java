import java.io.*;
import java.util.StringTokenizer;

// 그림
public class BOJ_1926 {
    static int n; // 도화지의 세로 크기
    static int m; // 도화지의 가로 크기
    static int[][] paper; // 도화지
    static boolean[][] visited; // 탐색 시 방문 여부
    static int size = 0; // 크기 측정 용도
    static int maxSize = 0; // 가장 넓은 도형의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 도화지 크기 입력
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그림 입력
        paper = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        int countPainting = 0; // 그림 개수
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(paper[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    countPainting++;

                    // 최대 그림의 크기 저장
                    if(size > maxSize) {
                        maxSize = size;
                    }
                    size = 0; // 각 그림마다 사이즈를 측정해야 하기에 0으로 초기화
                }
            }
        }
        // 출력
        sb.append(countPainting).append("\n");
        sb.append(maxSize);
        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void dfs(int row, int col) {
        visited[row][col] = true; // 방문 체크
        size++; // 사이즈 측정

        // 상
        if(row > 0) {
            if(paper[row - 1][col] == 1 && !visited[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 하
        if(row < n - 1) {
            if(paper[row + 1][col] == 1 && !visited[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 좌
        if(col > 0) {
            if(paper[row][col - 1] == 1 && !visited[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 우
        if(col < m - 1) {
            if(paper[row][col + 1] == 1 && !visited[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
    }
}
