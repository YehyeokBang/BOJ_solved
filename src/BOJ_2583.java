import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 영역 구하기
public class BOJ_2583 {
    static int N; // height
    static int M; // width
    static int[][] paper; // 모눈종이
    static boolean[][] visited; // 방문 여부
    static int size = 0; // 분리된 영역의 넓이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // N, M, K 입력
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N + 1][M + 1];

        int K = Integer.parseInt(st.nextToken()); // 그릴 직사각형 개수
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int bottomLeftX = Integer.parseInt(st.nextToken());
            int bottomLeftY = Integer.parseInt(st.nextToken());
            int topRightX = Integer.parseInt(st.nextToken());
            int topRightY = Integer.parseInt(st.nextToken());

            for(int x = bottomLeftX; x < topRightX; x++) {
                for(int y = bottomLeftY; y < topRightY; y++) {
                    paper[y][x] = 1;
                }
            }
        }

        int count = 0; // 분리된 영역의 개수
        ArrayList sizeArray = new ArrayList();
        visited = new boolean[N + 1][M + 1];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 분리된 영역이고 방문하지 않은 경우 dfs 탐색
                if(paper[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++; // dfs() 사용 횟수 == 분리된 영역의 개수

                    // 분리된 영역의 크기 구하고 다음 영역을 위해 저장 및 초기화
                    sizeArray.add(size);
                    size = 0;
                }
            }
        }

        // 분리된 영역의 수
        sb.append(count).append("\n");

        // 각 영역의 넓이를 오름차순으로 정렬
        sizeArray.sort(Comparator.naturalOrder());
        for(int i = 0; i < sizeArray.size(); i++) {
            sb.append(sizeArray.get(i));
            sb.append(" ");
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 깊이 우선 탐색
    static void dfs(int row, int col) {
        visited[row][col] = true;
        size++;

        // 상
        if(row > 0) {
            if(paper[row - 1][col] == 0 && !visited[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 하
        if(row < N - 1) {
            if(paper[row + 1][col] == 0 && !visited[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 좌
        if(col > 0) {
            if(paper[row][col - 1] == 0 && !visited[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 우
        if(col < M - 1) {
            if(paper[row][col + 1] == 0 && !visited[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
    }
}
